import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;

public class Rewriter {
    public static void rewrite() {

        try (OutputStream fos = new FileOutputStream("user.json");
             InputStream fis = new FileInputStream("file.txt");
             Scanner scanner = new Scanner(fis);) {

            scanner.nextLine();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            StringBuilder strb = new StringBuilder();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] userData = line.split(" ");
                String name = userData[0];
                Integer age = Integer.parseInt(userData[1]);

                strb.append(gson.toJson(new User(name, age)));
            }
            String str = strb.toString();

            fos.write(str.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
