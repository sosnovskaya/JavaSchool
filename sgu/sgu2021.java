package com.company;

import java.util.Scanner;

public class sgu2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;

         for (int i = 0; i < n; i++) {
             int num = scanner.nextInt();
             if(num > max){
                 max = num;
             }
             arr[i] = num;
        }

        int newMax = max / 2;
        for (int i = 0; i < n; i++) {
            if(arr[i] == max) {
                arr[i] = max / 2;
            }
            if(arr[i] > newMax){
                newMax = arr[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if(arr[i] == newMax) {
                arr[i] = newMax / 2;
            }
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
