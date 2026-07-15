import java.util.*;

public class TwoPointersSlidingWindow {

    // --------------------------------------------------
    // Scenario 1: Pair Sum
    // --------------------------------------------------
    public static int[] findPairSum(int[] transactions, int target) {
        int left = 0, right = transactions.length - 1;

        while (left < right) {
            int sum = transactions[left] + transactions[right];

            if (sum == target)
                return new int[]{transactions[left], transactions[right]};
            else if (sum < target)
                left++;
            else
                right--;
        }

        return new int[]{-1, -1};
    }

    // --------------------------------------------------
    // Scenario 2: Triplets with Target Sum
    // --------------------------------------------------
    public static List<List<Integer>> findTriplets(int[] jobs, int target) {

        Arrays.sort(jobs);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < jobs.length - 2; i++) {

            if (i > 0 && jobs[i] == jobs[i - 1])
                continue;

            int left = i + 1;
            int right = jobs.length - 1;

            while (left < right) {

                int sum = jobs[i] + jobs[left] + jobs[right];

                if (sum == target) {

                    result.add(Arrays.asList(jobs[i], jobs[left], jobs[right]));

                    while (left < right && jobs[left] == jobs[left + 1])
                        left++;

                    while (left < right && jobs[right] == jobs[right - 1])
                        right--;

                    left++;
                    right--;

                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    // --------------------------------------------------
    // Scenario 3: Maximum Sum Subarray of Size K
    // --------------------------------------------------
    public static int maxSubarrayOfSizeK(int[] cpuLoad, int k) {

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;

        for (int end = 0; end < cpuLoad.length; end++) {

            windowSum += cpuLoad[end];

            if (end >= k - 1) {

                maxSum = Math.max(maxSum, windowSum);

                windowSum -= cpuLoad[start];
                start++;
            }
        }

        return maxSum;
    }

    // --------------------------------------------------
    // Scenario 4: Minimum Window Substring
    // --------------------------------------------------
    public static String minWindowSubstring(String s, String t) {

        if (s.length() == 0 || t.length() == 0)
            return "";

        Map<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        Map<Character, Integer> window = new HashMap<>();

        int required = need.size();
        int formed = 0;

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) &&
                window.get(c).intValue() == need.get(c).intValue())
                formed++;

            while (formed == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char ch = s.charAt(left);

                window.put(ch, window.get(ch) - 1);

                if (need.containsKey(ch) &&
                    window.get(ch) < need.get(ch))
                    formed--;

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" :
                s.substring(minStart, minStart + minLen);
    }

    // --------------------------------------------------
    // Scenario 5: Longest Subarray with At Most N Distinct
    // --------------------------------------------------
    public static int longestSubarrayWithAtMostNDistinct(int[] keyIds, int n) {

        Map<Integer, Integer> freq = new HashMap<>();

        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < keyIds.length; end++) {

            freq.put(keyIds[end],
                    freq.getOrDefault(keyIds[end], 0) + 1);

            while (freq.size() > n) {

                int leftKey = keyIds[start];

                freq.put(leftKey, freq.get(leftKey) - 1);

                if (freq.get(leftKey) == 0)
                    freq.remove(leftKey);

                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }

    // --------------------------------------------------
    // Main Method
    // --------------------------------------------------
    public static void main(String[] args) {

        // Scenario 1
        System.out.println("Scenario 1: Pair Sum");
        int[] arr1 = {2, 5, 7, 11, 15};
        System.out.println(Arrays.toString(findPairSum(arr1, 18)));

        // Scenario 2
        System.out.println("\nScenario 2: Triplets");
        int[] jobs = {1, 2, 3, 4, 5, 6};
        List<List<Integer>> triplets = findTriplets(jobs, 10);
        for (List<Integer> t : triplets)
            System.out.println(t);

        // Scenario 3
        System.out.println("\nScenario 3: Max Sum Window");
        int[] cpu = {2, 1, 5, 1, 3, 2};
        System.out.println(maxSubarrayOfSizeK(cpu, 3));

        // Scenario 4
        System.out.println("\nScenario 4: Minimum Window");
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindowSubstring(s, t));

        // Scenario 5
        System.out.println("\nScenario 5: Longest Subarray with At Most N Distinct");
        int[] keys = {1, 2, 1, 2, 3, 2, 2, 1};
        System.out.println(longestSubarrayWithAtMostNDistinct(keys, 2));
    }
}