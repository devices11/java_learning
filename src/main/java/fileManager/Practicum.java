package fileManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Practicum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            System.out.println("Введите путь к файлу/директории: ");
            String enteredPath = scanner.nextLine();
            Path path = Paths.get(enteredPath); // создайте переменную пути
            if (!Files.exists(path)) { // проверьте, не ошибся ли пользователь
                System.out.println("Введённый путь не существует.");
                break;
            }
            switch (command) {
                case "exit":
                    System.out.println("Выход.");
                    System.exit(0); // пользователь хочет найти выход, выход есть всегда
                    break;
                case "ls":
                    try {
                        for (String element : Objects.requireNonNull(path.toFile().list())) {
                            System.out.println(element);
                        }
                    } catch (Exception e) {
                        System.out.println("Произошла ошибка при запросе содержимого директории.");
                        e.printStackTrace();
                    }
                    break;

                case "mkdir":
                    try {
                        Files.createDirectory(path);
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при создании директории.");
                        e.printStackTrace();
                    }
                    break;
                case "touch":
                    try {
                        Files.createFile(path);
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при создании файла.");
                        e.printStackTrace();
                    }
                    break;
                case "rename":
                    System.out.println("Введите новое имя файла/директории: ");
                    String newName = scanner.nextLine();

                    try {
                        Files.move(path, path.resolveSibling(newName), StandardCopyOption.REPLACE_EXISTING); // с помощью опции StandardCopyOption.REPLACE_EXISTING
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при переименовании файла/директории.");
                        e.printStackTrace();
                    }
                    break;
                case "rm_file":
                    try {
                        if (Files.exists(path)) {
                            Files.deleteIfExists(path);
                        } else {
                            System.out.println("С помощью этой команды можно удалить только файл!");
                        }
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при удалении файла.");
                        e.printStackTrace();
                    }
                default:
                    System.out.println("Извините, такой команды пока нет.");
            }

        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("ls - посмотреть содержимое директории.");
        System.out.println("mkdir - создать директорию.");
        System.out.println("touch - создать файл.");
        System.out.println("rename - переименовать директорию/файл.");
        System.out.println("rm_file - удалить файл.");
        System.out.println("exit - выход.");
    }

    //ПРОСТО ДЛЯ ИНФО
    private void INFO() throws IOException {
        //Запись по символьно
        Writer fileWriter = new FileWriter("filewriter.txt", true); //append = true добавить в конец файла

        fileWriter.write("новая запись в новый файл\n");
        fileWriter.write("добавляем текст");

        fileWriter.close();

        //Чтение по символьно
        Reader fileReader = new FileReader("filereader.txt");

        int data = fileReader.read();
        while (data != -1) {
            System.out.print((char) data);
            data = fileReader.read();
        }

        fileReader.close();

        //Чтение через буфер строками
        FileReader reader = new FileReader("bufferedreader.txt");
        BufferedReader br = new BufferedReader(reader);

        while (br.ready()) {
            String line = br.readLine();
            System.out.println(line);
        }

        br.close();


        final String HOME = System.getProperty("user.home");
        // создаём файл testFile
        Path testFile =
                Files.createFile(Paths.get(HOME, "testFile.txt"));

        if (Files.exists(Paths.get(HOME, "testFile.txt"))) {
            System.out.println("Файл успешно создан.");
        }

        // создаём директорию testDirectory
        Path testDirectory =
                Files.createDirectory(Paths.get(HOME, "testDirectory"));
        if (Files.exists(Paths.get(HOME, "testDirectory"))) {
            System.out.println("Директория успешно создана.");
        }

        // перемещаем файл testFile в директорию testDirectory
        testFile = Files.move(testFile,
                Paths.get(HOME, "testDirectory", "testFile.txt"),
                REPLACE_EXISTING);

        if (Files.exists(
                Paths.get(HOME, "testDirectory", "testFile.txt"))) {

            System.out.println("Файл перемещён в testDirectory.");
        }

        // удаляем файл
        Files.delete(testFile);
        if (!Files.exists(
                Paths.get(HOME, "testDirectory", "testFile.txt"))) {

            System.out.println("Тестовый файл удалён.");
        }

        // удаляем пустую директорию
        Files.delete(testDirectory);
        if (!Files.exists(Paths.get(HOME, "testDirectory"))) {
            System.out.println("Директория удалена.");
        }
    }

}
