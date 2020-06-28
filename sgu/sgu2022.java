package com.company;

import java.util.Scanner;

public class sgu2022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i != j && array[j] % array[i] == 0)
                    count++;
            }
        }
        System.out.println(count);
    }
}
