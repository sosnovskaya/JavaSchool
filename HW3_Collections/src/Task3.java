import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        Pattern pattern = Pattern.compile("[a-zA-z]+");
        Map<String,Integer> words = new HashMap<>();
        String line;
        while((line = reader.readLine()) != null){
            Matcher matcher = pattern.matcher(line.toLowerCase());
            while (matcher.find()){
                String word = matcher.group();
                if(words.containsKey(word))
                    words.put(word,words.get(word) + 1);
                else
                    words.put(word,1);
            }
        }
        for(Map.Entry<String,Integer> word: words.entrySet())
            System.out.println(word.getKey() + " - " + word.getValue());
    }
}
