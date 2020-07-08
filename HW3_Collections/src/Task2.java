import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    public static void main(String[] args) throws IOException {
        Comparator<String> lengthComparator = Comparator.comparing(str -> str.length());
        Comparator<String> comp = lengthComparator.thenComparing(Comparator.naturalOrder());
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        Pattern pattern = Pattern.compile("[a-zA-z]+");
        Set<String> words = new TreeSet<>(comp);
        String line;
        while((line = reader.readLine()) != null){
            Matcher matcher = pattern.matcher(line.toLowerCase());
            while (matcher.find()){
                words.add(matcher.group());
            }
        }
        for(String word : words)
            System.out.println(word);
    }
}
