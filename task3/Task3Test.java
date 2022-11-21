package module10.task3;

import java.io.*;
import java.util.*;

public class Task3Test {

    public static void main(String[] args) throws IOException {

        File file = new File("src/main/java/module10/task3/words.txt");
        System.out.println("wordCounting(file) = " + wordCounting(file));

    }

    public static Map<String, Integer> wordCounting (File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String data;

        Map<String, Integer> result = new HashMap<>();

        while ((data = bufferedReader.readLine()) != null) {
            if (!data.isBlank()) {
                String[] word = data.split("\\s");
                for (String s :
                        word) {
                    if (!result.containsKey(s)) {
                        result.put(s, 1);
                    } else {
                        result.put(s, result.get(s) + 1);
                    }
                }
            }
        }

        Comparator<String> comparator = (o1, o2) -> result.get(o1)<result.get(o2)? 1: -1;

        Map<String, Integer> treeMap = new TreeMap<>(comparator);
        treeMap.putAll(result);
        return treeMap;
    }
}

