package test;

import com.jfinal.core.JFinal;

/**
 * Created by mac on 2017/3/14.
 */
public class Main {
    public static void main(String[] args) {
        JFinal.start("src/main/webapp", 10080, "/");
    }
}
