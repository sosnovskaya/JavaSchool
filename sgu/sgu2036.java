package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sgu2036 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Pattern pattern = Pattern.compile("[aeuiyo]{3,}");
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            Matcher matcher = pattern.matcher(str);
            if (matcher.find())
                continue;
            System.out.println(str);
        }
    }
}
