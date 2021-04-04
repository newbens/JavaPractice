package 恒生;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

    }

    public synchronized void test1() {
        System.out.println("test1");
    }

    public synchronized void test2() {
        System.out.println("test2");
    }

    public synchronized static void test3() {
        System.out.println("test3");
    }
}
