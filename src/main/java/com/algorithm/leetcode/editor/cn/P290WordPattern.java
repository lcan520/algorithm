//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 
//
// 示例1: 
//
// 
//输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 
//输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 
//输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= pattern.length <= 300 
// pattern 只包含小写英文字母 
// 1 <= s.length <= 3000 
// s 只包含小写英文字母和 ' ' 
// s 不包含 任何前导或尾随对空格 
// s 中每个单词都被 单个空格 分隔 
// 
// Related Topics 哈希表 字符串 👍 462 👎 0


package com.algorithm.leetcode.editor.cn;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

import java.util.HashMap;

public class P290WordPattern {
    public static void main(String[] args) {
        Solution solution = new P290WordPattern().new Solution();
        TimeInterval timer = DateUtil.timer();
        // TODO 代码调用solution.<method>
        long interval = timer.interval();
        System.out.println("interval = " + interval + "ms");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> patternMap = new HashMap<>();
        HashMap<String, Character> strMap = new HashMap<>();
        String[] strings = s.split(" ");
        if (strings.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (patternMap.get(pattern.charAt(i)) != null && !patternMap.get(pattern.charAt(i)).equals(strings[i])) {
                return false;
            }
            if (strMap.get( strings[i]) != null && !strMap.get( strings[i]).equals(pattern.charAt(i))) {
                return false;
            }
            patternMap.put(pattern.charAt(i), strings[i]);
            strMap.put(strings[i], pattern.charAt(i));
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    
}   

 