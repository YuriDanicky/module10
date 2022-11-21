package module10.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class Task2Test {
    public static void main(String[] args) throws IOException {

        File file = new File("src/main/java/module10/task2/file.txt");
        toJsonFile(file);

    }


    public static void toJsonFile(File file) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        List<User> list = new LinkedList<>();
        String line;

        // for skip first line:
        bufferedReader.readLine();

        while ((line = bufferedReader.readLine()) != null) {
             String[] data = line.split("\\s");
             list.add(new User(data[0], Integer.parseInt(data[1] )));
         }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
        OutputStream fos = new FileOutputStream("src/main/java/module10/task2/user.json");
        fos.write(json.getBytes(StandardCharsets.UTF_8));
    }
}