//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 516 👎 0


package com.algorithm.leetcode.editor.cn;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        TimeInterval timer = DateUtil.timer();
        boolean palindrome = solution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
        long interval = timer.interval() / 1000L;
        System.out.println("interval = " + interval);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        // ascii 数字 48 - 57 大小字符 65 - 90 小写字符 97 - 122
        // 双指针
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (checkChar(s.charAt(l))) {
                if (checkChar(s.charAt(r))) {
                    if (!equles(s.charAt(l), s.charAt(r))) {
                        return false;
                    } else {
                        r--;
                        l++;
                    }
                } else {
                    r--;
                }
            } else {
                l++;
            }
        }
        return true;
    }

    boolean checkChar(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    boolean equles(char a, char b) {
        if (a == b) {
            return true;
        }
        if (a >= 'a' && a <= 'z') {
            return (a - 32 == b);
        }
        if (b >= 'a' && b <= 'z') {
            return (b - 32 == a);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    
}   

 