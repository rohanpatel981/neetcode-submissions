class Twitter {
    Map<Integer, List<Integer>> followMap;
    PriorityQueue<int[]> pq;
    int time;

    public Twitter() {
        pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        followMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        pq.offer(new int[]{time++, userId, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        List<int[]> tempPQList = new ArrayList<>();
        Set<Integer> followers = new HashSet<>();

        if (followMap.containsKey(userId)) {
            followers.addAll(followMap.get(userId));
        }
        
        followers.add(userId);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (followers.contains(curr[1]))
                res.add(curr[2]);

            tempPQList.add(curr);

            if (res.size() == 10)
                break;
        }

        for (int[] c : tempPQList)
            pq.offer(c);

        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new ArrayList<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        List<Integer> followerList = new ArrayList<>();

        if (followMap.containsKey(followerId)) {
            followerList = followMap.get(followerId);
        }
        List<Integer> t = new ArrayList<>();

        for (int x : followerList) {
            if (x != followeeId)
                t.add(x);
        }
        
        followMap.put(followerId, t);
    }
}
