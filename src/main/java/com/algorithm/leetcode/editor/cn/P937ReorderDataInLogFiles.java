//给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。 
//
// 有两种不同类型的日志： 
//
// 
// 字母日志：除标识符之外，所有字均由小写字母组成 
// 数字日志：除标识符之外，所有字均由数字组成 
// 
//
// 请按下述规则将日志重新排序： 
//
// 
// 所有 字母日志 都排在 数字日志 之前。 
// 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。 
// 数字日志 应该保留原来的相对顺序。 
// 
//
// 返回日志的最终顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 
//art zero"]
//输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6
//"]
//解释：
//字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
//数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
// 
//
// 示例 2： 
//
// 
//输入：logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
//
//输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= logs.length <= 100 
// 3 <= logs[i].length <= 100 
// logs[i] 中，字与字之间都用 单个 空格分隔 
// 题目数据保证 logs[i] 都有一个标识符，并且在标识符之后至少存在一个字 
// 
//
// Related Topics 数组 字符串 排序 👍 194 👎 0


package com.algorithm.leetcode.editor.cn;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

import java.util.Arrays;

public class P937ReorderDataInLogFiles {
    public static void main(String[] args) {
        Solution solution = new P937ReorderDataInLogFiles().new Solution();
        TimeInterval timer = DateUtil.timer();
        // TODO 代码调用solution.<method>
        solution.reorderLogFiles(new String[]{"wpylev6cnqv8 447241070789889321113517804297550370", "2syod 60098540876848105552318 69698830167476212 2", "iuw2x1r qmxealfvosqgkv yunonsq nxcuwudndrpsroty h", "vclnqwkdr7h 5515 892770977116949342793820104705 3", "5y08u4f5ba swixvlwipfhtxavvzrdyxtnronckklvh f kzd", "2k63p1p 542447297738584 22237063423417308275099706", "qrj 467859 382 451796621324556 12022 72631305 0429", "vopck4 huqziggmwvcsermnujnpplihttviwei lsrqmbw b n", "s 7257018672440110203152567646 961657508453405583", "94j 1800907 54116251858 19612167 218608 1 504204 4", "u34lvgmoh 631217074786612695089137448 5635620839 5", "dsrojn8aeojx 27159799084241651870 76594680 195 051", "kteuav 77685739 6366458436088787165747310 78 3849", "dg8gco0sc2 10811560194867165521681 718 42498 1 52", "gdg 900670532316533434070453812 9115641245822 122", "ytlmfg 658910166131 170942932 70238 0783568 64777", "gi6d2lg8 ekwbnzeqrrzijgexvpcgfnhrkfhtmegaqon hsa u", "y8zhzn jjtbwpfrbcsuj zmseejb vcsovstaewtgtj nbsnlj", "cp1qsk5 dstuzhik alqxnmztxnwdve simoynsfffwyacl nr", "a11zjdza15gi zuighjavkfidjjx kgmbriwxbjcsv shtfjz", "3dpx3f28wa1 dhe jb uatgwooxclfj w t qaahvyiy lthj", "9ymabvjk4xq waujeijoltuy heoekaqmggmpdkynngne sl x", "n3l09gzpppgc dfnfxeaskknllixe tvtbemewtkwd bfbhm l", "one 143245418564431590 555274555077126490673 23406", "2dlvtxq57 11 0399853766553806651446400571374174 7", "l0xsyrtf9foe jcsjyzbux hpxxwwsyxwjcdqbuzrxuvdf n n", "o ufjxgmiohhacgwhprzqklpbleggurqygvmyrqtiwwusaa fq", "gr jmhsaanfrndkvkrdepfqvnathkheq bjtvzacabyfch xw", "12hrfmpyxql 509513107446443470266800090 12 36792 5", "ei mfmrujazj hvcaeoejhbvsxlnbcofdparedjvuqoigbwv h", "158mo1 fxwvcxyaz gimthvk t tbkpxnyomitu i foi t i", "1mpnz91abn8 857526216042344 529 86 555850 074136 6", "gvf69aycgz vd wzshq vqqcoscdfgtclfpoqz kcnbk yqrta", "05tv1dyuuln 3010253552744498232332 86540056 5488 0", "1kjt2sp 76661129172454994454966100212569762 877775", "k8fq mhahouacluusiypbhmbxknagj nrenkpsijov tspqd s", "a 05783356043073570183098305205075240023467 24 63", "0c 821 1288302446431573478713998604686702 0584599", "e 02985850443721 356058 49996149758367 64432663 32", "1zayns7ifztd kwmwsthxzxvvctzoejspeobtavhzxzpot u n", "o0sh3 qn nqjaghnmkckhvuauuknqbuxwalgva nt gfhqm en", "094qnly wgkmupkjobuup gshx wcblufmjumyuahsx n ai k", "j69r2ugwa6 zuoywue chhwsfdprfygvliwzmohqgrxn ubwtm", "2mkuap uqfwog jqzrkoorsompgkdlql wpauhkzvig ftb l", "x 929 4356109428379557082235487428356570127401 832", "jns07q8 idnlfsaezcojuafbgmancqpegbzy q qwesz rmy n", "phk1cna 086 027760883273 64658492093523655560824 2", "jbemfs9l9bs0 8147538504741452659388775 5 32 180 09", "ac9cwb9 524689619771630155 8125241949139653850678", "9eke perwsfqykyslfmcwnovenuiy urstqeqaezuankek czq"});
        long interval = timer.interval();
        System.out.println("interval = " + interval + "ms");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {//运用到了java里的泛型，第二个参数重新定义排序规则
            String[] split1 = log1.split(" ", 2); //将log1 按分隔符“ ” ，分成2份，即把标识符分开来
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));//判断除标识符外的第一个字符是数字true，字母false
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) { //如果两个日志都是字母日志
                int cmp = split1[1].compareTo(split2[1]); //先比较内容字母split1>split2则返回1，等于返0，小于返-1
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);//若内容字母相同则比较标识符
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            //如果split1是数字字符，且split2是数字字符返回0，
            // 如果split1是数字字符，且split2是字母字符返回1，即split1>split2,从小到大排序，split2提前
            // 如果split1是字母字符，返回-1，
        });
        return logs;
    }

    private boolean digest(String val1) {
        String s = val1.split(" ")[1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' ') {
                continue;
            }
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    
}   

 