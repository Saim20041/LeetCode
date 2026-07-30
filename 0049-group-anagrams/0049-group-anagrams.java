class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char arr[] = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            if(!map.containsKey(s)){
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(strs[i]);          
        }
        List<List<String>> list = new ArrayList<>();
        for(String key: map.keySet()){
            list.add(map.get(key));
        }
        return list;
    }
}