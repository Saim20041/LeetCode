class Solution {
    public double angleClock(int hour, int minutes) {
        
        double hourAngle = (hour*30 + (((double)minutes/60)*30))%360;
        int minAngle = minutes*6;
        double result = Math.abs((double)minAngle - (double)hourAngle);
        if(result > 180){
            result = result - 180;
            result = 180 - result;
        }
        return result;
    }
}