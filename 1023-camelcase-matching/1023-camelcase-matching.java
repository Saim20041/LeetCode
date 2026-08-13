class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int n = queries.length;
        List<Boolean> res = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            int index = 0;
            String curr = queries[i];
            boolean valid = true;

            for (int j = 0; j < curr.length(); j++) {
                char ch = curr.charAt(j);

                if (Character.isUpperCase(ch)) {
                    if (index == pattern.length() || ch != pattern.charAt(index)) {
                        valid = false;
                        break;
                    }
                }

                if (index < pattern.length() && ch == pattern.charAt(index)) {
                    index++;
                }
            }

            if (index != pattern.length()) {
                valid = false;
            }

            res.add(valid);
        }

        return res;
    }
}