class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int med1 = 0, med2 = 0, i = 0, j = 0;

        for (int count = 0; count < (len1 + len2) / 2 + 1; ++count) {
            med2 = med1;
            if (i < len1 && j < len2) {
                if (nums1[i] > nums2[j]) {
                    med1 = nums2[j];
                    j++;
                } else {
                    med1 = nums1[i];
                    i++;
                }
            } else if (i < len1) {
                med1 = nums1[i];
                i++;
            } else if (j < len2) {
                med1 = nums2[j];
                j++;
            }
        }

        if ((len1 + len2) % 2 == 0) {
            return (double) (med1 + med2) / 2.0;
        }
        return (double) med1;
    }
}
