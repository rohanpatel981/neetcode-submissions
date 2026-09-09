class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String s : strs) {
            res.append(s.length()).append("#").append(s);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < str.length(); ) {
            String l = "";

            while(i < str.length() && str.charAt(i) != '#')
                l += str.charAt(i++);
            
            int j = Integer.parseInt(l);

            if (j == 0) 
                res.add("");
            else {
                res.add(str.substring(i + 1, i + 1 + j));
            }

            i = i + j + 1;
        }

        return res;
    }
}
