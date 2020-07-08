import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        List<String> strings = new ArrayList<>();
        String string;
        while ((string = reader.readLine()) != null){
            strings.add(string);
        }
        for (int i = strings.size() - 1; i >= 0; i--) {
            System.out.println(strings.get(i));
        }
    }
}
