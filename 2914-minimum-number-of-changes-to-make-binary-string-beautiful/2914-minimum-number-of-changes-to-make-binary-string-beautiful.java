class Solution {
    public int minChanges(String s) {
        int changes = 0;
        int prev = -1;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '0' && prev != 1){
                prev = 0;
                continue;
            }
            if(ch == '1' && prev != 0){
                prev = 1;
                continue;
            }
            if(ch == '0' && prev == 1){
                prev = 0;
                if(i % 2 == 1){
                    changes+=1;
                }
            }
            if(ch == '1' && prev == 0){
                prev = 1;
                if(i % 2 == 1){
                    changes+=1;
                }
            }
        }
        return changes;
    }
}