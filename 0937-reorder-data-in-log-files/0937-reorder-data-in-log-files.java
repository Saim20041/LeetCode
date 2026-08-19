class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String arr1[] = a.split(" ");
            String arr2[] = b.split(" ");
            if (Character.isDigit(arr1[1].charAt(0)) &&
                    Character.isDigit(arr2[1].charAt(0))) {

                return 0;
            }
            if (Character.isDigit(arr1[1].charAt(0))) {
                return 1;
            }
            if (Character.isDigit(arr2[1].charAt(0))) {
                return -1;
            }
            int i = 1;
            while (i < arr1.length && i < arr2.length) {
                if (arr1[i].compareTo(arr2[i]) != 0) {
                    return arr1[i].compareTo(arr2[i]);
                }
                if (i == arr1.length - 1 && i == arr2.length - 1) {
                    break;
                }
                if (i == arr1.length - 1) {
                    return -1;
                }
                if (i == arr2.length - 1) {
                    return 1;
                }
                i++;
            }
            return arr1[0].compareTo(arr2[0]);
        });
        return logs;
    }
}