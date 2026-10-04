class Solution {
    public int shipWithinDays(int[] weights, int days) {
         int low = 0;
        int high = 0;

        for (int i = 0; i < weights.length; i++) {
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
         while (low <= high) {

            int mid = (low + high) / 2;

            int currWt = 0;
            int i = 0;
            int requiredDays = 1;

            while (i < weights.length) {

                if (currWt + weights[i] <= mid) {
                    currWt += weights[i];
                    i++;
                } 
                else {
                    requiredDays++;
                    currWt = 0;
                }
            }

            if (requiredDays <= days) {
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}