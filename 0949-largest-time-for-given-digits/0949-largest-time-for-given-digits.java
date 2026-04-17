class Solution {
    public String largestTimeFromDigits(int[] arr) {
        String result = "";
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                for(int k=0;k<arr.length;k++){
                    if(i == j || j==k || k ==i ) continue;
                    String hh = String.valueOf(arr[i]) + String.valueOf(arr[j]);
                    String mm = String.valueOf(arr[k]) + String.valueOf(arr[6-i-j-k]);
                    String time = hh+":"+mm;
                    if(hh.compareTo("24")<0 && mm.compareTo("60") <0 && result.compareTo(time)<0 ) result =time;
                }
            }
        }
        return result;
    }
}