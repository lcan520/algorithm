package demo;

import java.util.Scanner;

/**
 * <p>
 *
 * </p>
 *
 * @author lcan520.cn
 * @date Created in 21:42 2021/9/25
 * @since 1.0.0
 */
public class MaxNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] split = s.split(";");
            String[] splitf = split[split.length - 1].split(",");
            String[] splitb = split[split.length - 2].split(",");
            String[] splitx = split[split.length - 3].split(",");

            boolean resultBool = true;
            int result = 0;
            // 构建系数
            for (int i = 0; i < split.length - 3; i++) {
                String[] split1 = split[i].split(",");
                double sum = 0.0d;
                int result1 = 0;
                for (int j = 0; j < split1.length; j++) {
                    sum = sum + Double.parseDouble(split1[j]) * Integer.parseInt(splitx[j]);
                    result1 = (int) (sum - Double.parseDouble(splitb[i]));
                }
                // 判断不等式
                if (">".equals(splitf[i]) && sum <= Double.parseDouble(splitb[i])) {
                    resultBool = false;
                }
                if (">=".equals(splitf[i]) && sum < Double.parseDouble(splitb[i])) {
                    resultBool = false;
                }
                if ("<".equals(splitf[i]) && sum >= Double.parseDouble(splitb[i])) {
                    resultBool = false;
                }
                if ("<=".equals(splitf[i]) && sum > Double.parseDouble(splitb[i]) ) {
                    resultBool = false;
                }
                if ("=".equals(splitf[i])  && sum != Double.parseDouble(splitb[i]) ) {
                    resultBool = false;
                }
                // 最大差值
                result = Math.max(result1, result1);
            }
            System.out.println(resultBool + " " + result);
        }
    }
}
