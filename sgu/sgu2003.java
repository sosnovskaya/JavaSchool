package com.company;

import java.util.Scanner;

public class sgu2003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        int altSum = 0;
        int sign = 1;
        for (int i = 0; i < nums; i++) {
            int num = scanner.nextInt();
            altSum += sign * num;
            sign *= -1;
        }
        System.out.println(altSum);
    }
}
