package demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author lcan520.cn
 * @date Created in 21:52 2021/11/11
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        // symble 初始化
        HashMap<String,List<String>> symble = new HashMap(2);
        symble.put("red", Arrays.asList("class","public","private"));
        symble.put("green",Arrays.asList("Integer","Float","Double"));
        String s = highLight("class Test {\n" +
                "    Integer a = 1;\n" +
                "}", symble);
        System.out.println(s);


    }


    public static String highLight(String content, HashMap<String, List<String>> symble){


        // 结果
        String result = "";

        // 词组
        String[] words = content.split(" ");

        boolean isNotMatch = false;
        // 查找关键字
        symble.forEach((tag,keywords) -> {
            // tag 标签

            // 遍历查找关键字
            keywords.forEach(keyword -> {

                // 遍历词组
                for (int i = 0; i < words.length; i++) {
                    if (keyword.equals(words[i])) {
                        ConcurrentHashMap concurrentHashMap;

                        StringBuffer buf = new StringBuffer();
                        buf.append("<");
                        buf.append(tag);
                        buf.append(">");
                        buf.append(words[i]);
                        buf.append("</");
                        buf.append(tag);
                        buf.append(">");
                        buf.append(" ");
                        words[i] = buf.toString();
                    }
                }
            });
        });

        for (String word : words) {
            result = result + word;
        }


        return result;

    }
}
