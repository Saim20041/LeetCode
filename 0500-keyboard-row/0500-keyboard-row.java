class Solution {
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        for (String str : words) {
            String test = str.toLowerCase();
            char ch = test.charAt(0);
            if (row1.indexOf(ch) != -1) {
                boolean res = checkRow(test, row1);
                if (res) {
                    list.add(str);
                }
            } else if (row2.indexOf(ch) != -1) {
                boolean res = checkRow(test, row2);
                if (res) {
                    list.add(str);
                }
            }
            else{
                boolean res = checkRow(test, row3);
                if (res) {
                    list.add(str);
                }
            }
        }
        String arr[] = new String[list.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;

    }

    public boolean checkRow(String str, String row) {

        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (row.indexOf(ch) == -1) {

                return false;
            }
        }
        return true;

    }

}