package com.company.processApi;


import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Date: Create in 14:55 2019/3/27
 */
public class ProcessApiTest {

    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("ping", "-n", "3", "www.baidu.com");

        Process process = pb.start();

        int i = process.exitValue();
//
//        InputStream inputStream = process.getInputStream();
//
//        System.out.println(inputStream.read());

        System.out.println("exitValue = " + i);
    }

}
