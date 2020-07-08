import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        List<String> strings = new ArrayList<>();
        String string;
        while ((string = reader.readLine()) != null){
            strings.add(string);
        }
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(" ");
        for(String str : nums)
            System.out.println(strings.get(Integer.parseInt(str)));
    }
}
