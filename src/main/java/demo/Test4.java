package demo;

import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @author lcan520.cn
 * @date Created in 23:18 2022/3/31
 * @since 1.0.0
 */
public class Test4 {
    public static void main(String[] args) {
        try {
            System.out.println("请输入一个大写字母，按回车确定：");
            int read = System.in.read();
            System.in.skip(2);

            // 排除错误数字，并且排除回车换行
            while (read < 'A' || read >= 'a') {
                System.out.println("输入错误，请重新输入一个大写字母，按回车确定：");
                read = System.in.read();
                System.in.skip(2);
            }
            System.out.println("你输入的大写字母是：" + (char) read);
            System.out.println("转换成小写字母是：" + (char) (read + 32));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
