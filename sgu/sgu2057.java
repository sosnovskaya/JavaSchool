package com.company;

import java.io.*;
import java.util.*;

public class sgu2057 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= n; i++) {
            String[] lineEls = reader.readLine().split(" ");
            int cmd = Integer.parseInt(lineEls[0]);
            if (cmd == 1) {
                int num = Integer.parseInt(lineEls[1]);
                if (map.containsKey(num)) {
                    map.put(num,map.get(num) + 1);
                } else map.put(num, 1);
            }
            if (cmd == 2) {
                for (int key: map.keySet()) {
                    if (map.get(key) == 1) {
                        map.remove(key);
                    } else {
                        map.put(key,map.get(key) -1);
                    }
                    System.out.println(key);
                    break;
                }
            }
        }
    }
}
