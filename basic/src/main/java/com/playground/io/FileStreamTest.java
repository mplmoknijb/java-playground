package com.playground.io;

import java.io.*;

public class FileStreamTest {

    private static final String FileName = "file.txt";

    public static void main(String[] args) {
        testWrite();
        testRead();
    }
    // 向文件写入
    public static void testWrite() {
        try {
            // 1 创建文件“file.txt”对应File对象
            File file = new File(FileName);
            // 2 创建文件“file.txt”对应的FileOutputStream对象，默认是关闭“追加模式”
            FileOutputStream fileOut1 = new FileOutputStream(file, true);
            // 3 创建FileOutputStream对应的PrintStream，方便操作。PrintStream的写入接口更便利
            PrintStream out1 = new PrintStream(fileOut1);
            // 4 向“文件中”写入26个字母
            out1.print("abcdefghijklmnopqrstuvwxyz");
            out1.close();

            // 5 创建文件“file.txt”对应的FileOutputStream对象，打开“追加模式”
            FileOutputStream fileOut2 = new FileOutputStream(file, true);
            // 6 创建FileOutputStream对应的PrintStream，方便操作。PrintStream的写入接口更便利
            PrintStream out2 = new PrintStream(fileOut2);
            // 7 向“文件中”写入"0123456789"+换行符
            out2.println("0123456789");
            out2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileInputStream 演示程序
     * 从文件读取
     */
    private static void testRead() {
        try {
            // 方法1：新建FileInputStream对象
            // 新建文件“file.txt”对应File对象
            File file = new File(FileName);
            FileInputStream in1 = new FileInputStream(file);

            // 方法2：新建FileInputStream对象
            FileInputStream in2 = new FileInputStream(FileName);

            // 方法3：新建FileInputStream对象
            // 获取文件“file.txt”对应的“文件描述符”
            FileDescriptor fdin = in2.getFD();
            // 根据“文件描述符”创建“FileInputStream”对象
            FileInputStream in3 = new FileInputStream(fdin);

            // 测试read()，从中读取一个字节
            char c1 = (char) in1.read();
            System.out.println("c1=" + c1);

            // 测试skip(long byteCount)，跳过4个字节
            in1.skip(25);

            // 测试read(byte[] buffer, int byteOffset, int byteCount)
            byte[] buf = new byte[10];
            in1.read(buf, 0, buf.length);
            System.out.println("buf=" + (new String(buf)));


            // 创建“FileInputStream”对象对应的BufferedInputStream
            BufferedInputStream bufIn = new BufferedInputStream(in3);
            // 读取一个字节
            char c2 = (char) bufIn.read();
            System.out.println("c2=" + c2);

            in1.close();
            in2.close();
            in3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
