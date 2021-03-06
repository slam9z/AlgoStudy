/*
 * @lc app=leetcode id=683 lang=java
 *
 * [683] K Empty Slots
 *
 * https://leetcode.com/problems/k-empty-slots/description/
 *
 * algorithms
 * Hard (33.78%)
 * Total Accepted:    31.8K
 * Total Submissions: 94.1K
 * Testcase Example:  '[1,3,2]\n1'
 *
 * 
 * There is a garden with N slots. In each slot, there is a flower. The N
 * flowers will bloom one by one in N days. In each day, there will be exactly
 * one flower blooming and it will be in the status of blooming since then.
 * 
 * 
 * 
 * Given an array flowers consists of number from 1 to N. Each number in the
 * array represents the place where the flower will open in that day.
 * 
 * 
 * 
 * For example, flowers[i] = x means that the unique flower that blooms at day
 * i will be at position x, where i and x will be in the range from 1 to N.
 * 
 * 
 * 
 * Also given an integer k, you need to output in which day there exists two
 * flowers in the status of blooming, and also the number of flowers between
 * them is k and these flowers are not blooming.
 * 
 * 
 * 
 * If there isn't such day, output -1.
 * 
 * 
 * Example 1:
 * 
 * Input: 
 * flowers: [1,3,2]
 * k: 1
 * Output: 2
 * Explanation: In the second day, the first and the third flower have become
 * blooming.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * flowers: [1,2,3]
 * k: 1
 * Output: -1
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The given array will be in the range [1, 20000].
 * 
 * 
 */
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        if (flowers == null || flowers.length == 0) {
            return 0;
        }

        TreeSet<Integer> set = new TreeSet<>();
        int res = 0;
        for (int i = 0; i < flowers.length; i++) {
            res++;
            set.add(flowers[i]);
            Integer lowerBound = set.lower(flowers[i]);
            Integer higherBound = set.higher(flowers[i]);

            if ((lowerBound != null) && (flowers[i] - lowerBound - 1 == k)
                    || (higherBound != null) && (higherBound - flowers[i] - 1 == k)) {
                return res;
            }
        }
        return -1;
    }
}
