class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+ 1);
        
        }
        List<String> bucket[] = new ArrayList[words.length+1];
        map.forEach((key, value)-> {
            if(bucket[value] == null){
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        });
        List<String> result = new ArrayList<>();
        int curr = 0;
        for(int i = words.length; i >= 1; i--){
            if(curr == k) break;
            if(bucket[i] == null) continue;
            Collections.sort(bucket[i]);
            for(String word : bucket[i]){
                result.add(word);
                curr++;
                if(curr == k) break;
            }
        }
        return result;
         
    }
}