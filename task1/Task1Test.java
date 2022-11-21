package module10.task1;

import java.io.*;

public class Task1Test {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/module10/task1/file.txt");

        System.out.println("readValidPhoneNumbers(file) = " + readValidPhoneNumbers(file));
    }

    //Task 1 solution:

    public static String readValidPhoneNumbers(File file) throws IOException {

        String regex1 = "\\(\\d{3}\\)\\s\\d{3}-\\d{4}";
        String regex2 = "\\d{3}-\\d{3}-\\d{4}";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String numbers;
        String result = "";

        while ((numbers = bufferedReader.readLine()) != null) {

            if (numbers.matches(regex1) || numbers.matches(regex2)) {
                result += numbers + "\n";
            }
        }
        return result;
    }
}

