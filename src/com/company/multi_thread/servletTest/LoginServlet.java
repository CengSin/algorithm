package com.company.multi_thread.servletTest;

class ALogin extends Thread {
    @Override
    public void run() {
        super.run();
        LoginServlet.doPost("a", "aa");
    }
}

class BLogin extends Thread {
    @Override
    public void run() {
        super.run();
        LoginServlet.doPost("b", "bb");
    }
}

/**
 * 线程不安全示例
 */
public class LoginServlet {

    private static String usernameRef;
    private static String passwordRef;

    synchronized public static void doPost(String username, String password) {
        /*非线程安全代码块，需要加入sync关键字*/
        try {
            usernameRef = username;
            if (usernameRef.equals("a")) {
                Thread.sleep(50);
            }
            passwordRef = password;
            System.out.println("username = " + usernameRef + ", password=" + passwordRef);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ALogin aLogin = new ALogin();
        aLogin.start();
        BLogin bLogin = new BLogin();
        bLogin.start();
    }

}
