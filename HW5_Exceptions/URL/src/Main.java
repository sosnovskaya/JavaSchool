import java.net.MalformedURLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Введите url сайта, содержимое которого вы хотите вывести на экран.");
            if(scanner.hasNextLine()){
                String url = scanner.nextLine();
                try {
                    if(UrlProcess.isOkUrl(url)){
                            UrlProcess.readContent(url);
                        break;
                    }
                } catch (UrlFormatException e) {
                    System.out.println(e.toString());
                } catch (ResourceAccessException e) {
                    System.out.println(e.toString());
                }
            }
        }
    }
}
