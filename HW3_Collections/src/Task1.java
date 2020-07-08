import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        Pattern pattern = Pattern.compile("[a-zA-z]+");
        Set<String> words = new HashSet<>();
        String line;
        while((line = reader.readLine()) != null){
            Matcher matcher = pattern.matcher(line.toLowerCase());
            while (matcher.find()){
                words.add(matcher.group());
            }
        }
        System.out.println(words.size());
    }
}
