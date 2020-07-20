import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlProcess {

    public static boolean isOkUrl(String url) throws UrlFormatException {
        String urlRegex = "^(http|https)://[-a-zA-Z0-9+&@#/%?=~_|,!:.;]*[-a-zA-Z0-9+@#/%=&_|]";
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(url);
        if(!matcher.matches())
            throw new UrlFormatException();
        return true;
    }

    public static void readContent(String url) throws UrlFormatException, ResourceAccessException {
        try {
            URL site = new URL(url);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(site.openStream()));
            String str;
            while((str = bufferedReader.readLine()) != null){
                System.out.println(str);
            }
        } catch (MalformedURLException e) {
            UrlFormatException urlFormatException = new UrlFormatException();
            urlFormatException.addSuppressed(e);
            throw urlFormatException;
        } catch (IOException e) {
            ResourceAccessException resourceAccessException = new ResourceAccessException();
            resourceAccessException.addSuppressed(e);
            throw resourceAccessException;
        }
    }

}
