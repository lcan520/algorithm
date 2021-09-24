package data_structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyBloomFilterTest {

    @Test
    void add() {
        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";
        MyBloomFilter filter = new MyBloomFilter();
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
    }

    @Test
    void contains() {
        Integer value1 = 13423;
        Integer value2 = 22131;
        MyBloomFilter filter = new MyBloomFilter();
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
    }

    @Test
    void binaryCompute() {
        System.out.println("两个位都为1时，结果才为1：" + Integer.toBinaryString(Integer.valueOf(0b110 & 0b100)));
        System.out.println("两个位都为0时，结果才为0：" + Integer.toBinaryString(Integer.valueOf(0b110 | 0b100)));
        System.out.println("两个位相同为0，相异为1：" + Integer.toBinaryString(Integer.valueOf(0b110 ^ 0b100)));
        System.out.println("0变1，1变0" + Integer.toBinaryString(Integer.valueOf(~0b110)));
        System.out.println("右移一位" + Integer.toBinaryString(Integer.valueOf(0b110 >> 1)));
        System.out.println("左移一位" + Integer.toBinaryString(Integer.valueOf(0b110 << 1)));
        System.out.println("各二进位全部左移若干位，高位丢弃，低位补0" + Integer.toBinaryString(Integer.valueOf(0b110 >> 16)));
        System.out.println("各二进位全部右移若干位，对无符号数，高位补0，有符号数，各编译器处理方法不一样，有的补符号位（算术右移），有的补0（逻辑右移）："
                + Integer.toBinaryString(Integer.valueOf(0b110 << 31)));
        System.out.println("各二进位全部右移若干位，无符号处理" + Integer.toBinaryString(Integer.valueOf(-0b110 >> 1)));
    }
}