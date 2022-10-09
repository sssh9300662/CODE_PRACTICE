package dynamic.medium;

/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 * It is guaranteed that the answer will fit in a 32-bit integer.
 * A subarray is a contiguous subsequence of the array.
 * 簡單來說，這題想要找的是最大乘積的子陣列。
 * - 每回合的最大值是當下的最大值與目前值找最大的
 * - 因為是乘積，當中又有負數會來攪局
 * - 這裡除了每次紀錄當下的最大值以外呢，也要同時紀錄當下的最小值，以免下一回合直接乘上負數
 *  - 切小的問題會是，每回合找最大值與最小值，而且最大最小值的找法為：
 *      最大值：max (目前值、上一回合 max * 目前值、上一回合 min * 目前值)
 *      最小值：min (目前值、上一回合 max * 目前值、上一回合 min * 目前值)
 *  - 這裡就會需要分別一個紀錄 max 與 min 的表，每回合我們只需要查表找出上一回合的最大最小值，並且更新這回合的值
 */
public class LeetCodeMaximumProductSubarray {
}
