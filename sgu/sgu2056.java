package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class sgu2056 {
    public static void main(String[] args) throws IOException {
        Map<String,Integer> map = new TreeMap<>();
        Scanner scanner =  new Scanner(new File("input.txt"));
        String word;
        while(scanner.hasNext()) {
            word = scanner.next().toLowerCase();
            if(map.containsKey(word))
                map.put(word,map.get(word) + 1);
            else
                map.put(word,1);
        }
        scanner.close();

        int mostPop = Collections.max(map.values());
        File out = new File("output.txt");
        FileWriter writer = new FileWriter(out, true);

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue().equals(mostPop))
                writer.write(entry.getKey() + "\n");
        }
        writer.flush();
        writer.close();
    }
}
