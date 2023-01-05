import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {


        String gamesFolderPath = "/Users/Games";
        StringBuilder log = new StringBuilder();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedTime = now.format(formatter);

        String[] dirsToCreate = {"src", "res", "savegames", "temp",
                "src/main", "src/test", "res/drawables", "res/vectors", "res/icons"};
        String[] filesToCreate = {"src/main/Main.java", "src/main/Utils.java"};

        for (String dir : dirsToCreate) {
            log.append("Дата и время: " + formattedTime + " - ");
            File directory = new File(gamesFolderPath + "/" + dir);
            if (directory.mkdir()) {
                log.append("Папка " + dir + " создана\n");
            } else {
                log.append("Не удалось создать папку " + dir + "\n");
            }
        }

        for (String file : filesToCreate) {
            log.append("Дата и время: " + formattedTime + " - ");
            File newFile = new File(gamesFolderPath + "/" + file);
            try {
                if (newFile.createNewFile()) {
                    log.append("Файл " + file + " создан\n");
                } else {
                    log.append("Не удалось создать файл " + file + "\n");
                }
            } catch (IOException e) {
                log.append("Не удалось создать файл " + file + "\n");
            }
        }


        try {
            File tempFile = new File(gamesFolderPath + "/temp/temp.txt");
            FileWriter writer = new FileWriter(tempFile);
            writer.write(log.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Не удалось записать в файл temp.txt");
        }
    }
}

