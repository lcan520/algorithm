//给你个整数数组 arr，其中每个元素都 不相同。 
//
// 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [4,2,1,3]
//输出：[[1,2],[2,3],[3,4]]
// 
//
// 示例 2： 
//
// 输入：arr = [1,3,6,10,15]
//输出：[[1,3]]
// 
//
// 示例 3： 
//
// 输入：arr = [3,8,-10,23,19,-4,-14,27]
//输出：[[-14,-10],[19,23],[23,27]]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 10^5 
// -10^6 <= arr[i] <= 10^6 
// 
//
// Related Topics 数组 排序 👍 83 👎 0


package com.algorithm.leetcode.editor.cn;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

import java.util.*;

public class P1200MinimumAbsoluteDifference {
    public static void main(String[] args) {
        Solution solution = new P1200MinimumAbsoluteDifference().new Solution();
        TimeInterval timer = DateUtil.timer();
        // TODO 代码调用solution.<method>
        List<List<Integer>> lists = solution.minimumAbsDifference(new int[]{40,11,26,27,-20});
        long interval = timer.interval();
        System.out.println("interval = " + interval + "ms");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, List<List<Integer>>> resultMap = new HashMap<>(arr.length / 2);
        int minimum = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            minimum = Math.min(arr[i + 1] - arr[i], minimum);
            if (arr[i + 1] - arr[i] > minimum) {
                continue;
            }
            List<List<Integer>> arrMap;
            if (resultMap.containsKey(minimum)) {
                arrMap = resultMap.get(minimum);
            } else {
                arrMap = new ArrayList<>();
            }
            ArrayList<Integer> arrList = new ArrayList<>();
            arrList.add(arr[i]);
            arrList.add(arr[i + 1]);
            arrMap.add(arrList);

            resultMap.put(minimum, arrMap);
        }
        return resultMap.get(minimum);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
    
}   

 