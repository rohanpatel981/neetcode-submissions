class Solution {
    List<List<Integer>> res = new ArrayList<>();

    private void search(int[] cand, int target, int sum, List<Integer> path, int index) {

        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (sum > target || index >= cand.length)
            return;

        
        path.add(cand[index]);
        search(cand, target, sum + cand[index], path, index + 1);
        path.remove(path.size() - 1);
        
        int next = index + 1;

        while (next < cand.length && cand[next - 1] == cand[next])
            next++;

        search(cand, target, sum, path, next);



    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        int sum = 0;
        Arrays.sort(candidates);
        search(candidates, target, sum, path, 0);
        return res;
    }
}
