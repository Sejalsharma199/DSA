class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0 , j = 0 ;
        while(i<firstList.length && j <secondList.length) {

            //find the intersections
            int start = Math.max(firstList[i][0] , secondList[j][0]);
            int end = Math.min(firstList[i][1] , secondList[j][1]);

            if(start<= end) {
                list.add(new int[]{
                    start , end
                });
            }
            //move the pointer of whose interval end first since future me abh uska kaam nai
            if(firstList[i][1]<secondList[j][1]) {
                i++;
            }

            else if(firstList[i][1]> secondList[j][1]) {
                j++;
            }
            //kisi ka interval chota nai hai dono ke same hai
            else {
                i++;
                j++;
            }
        }
        //convert arraylist to int[]
        int[][] ans = new int[list.size()][2];
        for(int k = 0 ; k<list.size() ; k++) {
            ans[k] = list.get(k);
        }
        return ans;
    }
}