package com.company;

import java.util.Scanner;

public class sgu2005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if(num < min){
                min = num;
                minIndex = i + 1;
            }
        }
        System.out.println(minIndex);
    }
}
