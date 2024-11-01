package readFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Practicum {
    static Map<String, Integer> frequencyMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        //Метод close() будет вызван автоматически, когда программа выйдет из блока try-with-resources.
        try (Reader reader = new FileReader("D:\\projects\\java_learning\\src\\main\\java\\readFile\\result.txt");
             BufferedReader br = new BufferedReader(reader)) {

                 // читайте файл построчно и сразу обновляйте frequencyMap.
            while(br.ready())

                 {
                     String line = br.readLine();
                     switch (line) {
                         case "A" -> add("A");
                         case "B" -> add("B");
                         case "C" -> add("C");
                         case "D" -> add("D");
                     }
                 }
             } catch(FileNotFoundException e) {
            e.printStackTrace();
        }


        // выведите результат в формате "<буква>: <количество>".
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void add(String line) {
        if (!frequencyMap.containsKey(line)) {
            frequencyMap.put(line, 1);
        } else {
            int count = frequencyMap.get(line) + 1;
            frequencyMap.put(line, count);
        }
    }
}