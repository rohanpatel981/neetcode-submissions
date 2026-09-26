class TimeMap {
    record Pair(int time, String value) {}
    Map<String, List<Pair>> umap;

    public TimeMap() {
        umap = new HashMap<>();
    }
    
    public void set(String key, String value, int time) {
        List<Pair> pair = new ArrayList<>();
        umap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(time, value));
    }
    
    public String get(String key, int time) {       
        List<Pair> pairs = umap.get(key);

        if (pairs == null)
            return "";

        int N = pairs.size();
        int low = 0, high = N - 1;
        String res = "";

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (time >= pairs.get(mid).time()) {
                res = pairs.get(mid).value();
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return res;
    }
}

/*
0               1
[1, happy], [3, sad]

*/
