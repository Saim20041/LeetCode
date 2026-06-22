class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            if("balon".contains(String.valueOf(ch))){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        int count = 0;

        while(map.getOrDefault('b',0) >= 1 &&
              map.getOrDefault('a',0) >= 1 &&
              map.getOrDefault('l',0) >= 2 &&
              map.getOrDefault('o',0) >= 2 &&
              map.getOrDefault('n',0) >= 1) {

            count++;

            map.put('b', map.get('b') - 1);
            map.put('a', map.get('a') - 1);
            map.put('l', map.get('l') - 2);
            map.put('o', map.get('o') - 2);
            map.put('n', map.get('n') - 1);
        }

        return count;
    }
}