class Twitter {
private Map<Integer, List<int[]>> tweetMap;
private Map<Integer, Set<Integer>> followMap;
private int time;

public Twitter() {
    tweetMap = new HashMap<>();
    followMap = new HashMap<>();
    time = 0;
}

public void postTweet(int userId, int tweetId) {
    tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
            .add(new int[]{time++, tweetId});
}

public List<Integer> getNewsFeed(int userId) {
    List<Integer> result = new ArrayList<>();

    // Max-heap: newest timestamp comes first
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a, b) -> Integer.compare(b[0], a[0])
    );

    // Include followed users and the user themselves
    Set<Integer> users = new HashSet<>(
        followMap.getOrDefault(userId, Collections.emptySet())
    );
    users.add(userId);

    // Add each user's newest tweet to the heap
    for (int uid : users) {
        List<int[]> tweets = tweetMap.get(uid);

        if (tweets != null && !tweets.isEmpty()) {
            int index = tweets.size() - 1;
            int[] tweet = tweets.get(index);

            // [timestamp, tweetId, userId, index]
            pq.offer(new int[]{
                tweet[0], tweet[1], uid, index
            });
        }
    }

    // Collect at most 10 newest tweets
    while (!pq.isEmpty() && result.size() < 10) {
        int[] curr = pq.poll();

        result.add(curr[1]);

        int uid = curr[2];
        int index = curr[3];

        // Add this user's previous tweet, if available
        if (index > 0) {
            int[] previous = tweetMap.get(uid).get(index - 1);

            pq.offer(new int[]{
                previous[0], previous[1], uid, index - 1
            });
        }
    }

    return result;
}

public void follow(int followerId, int followeeId) {
    followMap.computeIfAbsent(followerId, k -> new HashSet<>())
             .add(followeeId);
}

public void unfollow(int followerId, int followeeId) {
    Set<Integer> followees = followMap.get(followerId);

    if (followees != null) {
        followees.remove(followeeId);
    }
}

}
