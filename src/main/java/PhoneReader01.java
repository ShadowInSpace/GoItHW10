import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneReader01 {
    public void read(File file) {
        try (InputStream fis = new FileInputStream(file);
             Scanner scanner = new Scanner(fis)) {
            Pattern pattern = Pattern.compile("[\\(]{0,1}[0-9]{3}[\\)]{0,1}[-\\s\\.]?[0-9]{3}[-]?[0-9]{4}$");

            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()) {
                    System.out.println(str);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
