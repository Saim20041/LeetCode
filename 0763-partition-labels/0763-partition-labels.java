class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, s.lastIndexOf(ch));
        }
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        int i = 0;
        while(i <= right && right < s.length()){
            int index = map.get(s.charAt(i));
            if(index > right){
                right = index;
            }
            if(i == right){
                list.add(right - left+1);
                left = right+1;
                right = right+1;
                
            }
            i++;

        }
        return list;
    }
}