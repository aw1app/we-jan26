import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

public class FileReadWriteAPIDemo {

    public static void main(String[] args) {

        Path path1 = Path.of("a.txt");

        List<String> lines = null;
        try {
            lines = Files.readAllLines(path1);
            System.out.println(" lines : " + lines);
        } catch (Exception e) {
        }

        // print all the lines of a.txt
//        for (int i = 0; i < lines.size(); i++) {
//            System.out.println(" line " + i + " : " + lines.get(i));
//        };

        for (String line : lines) {
            System.out.println(" line " + line);
        }

        // Read all content in a single string
        System.out.println("\n Read all content in a single string");
        try {
            String content = Files.readString(path1);
            System.out.println(" content " + content);
        } catch (Exception e) {
            System.out.println(" Exception happened " + e.getMessage());
        }


        // WRITING TO A FILE
        Path path2 = Path.of("b.txt");
        try {
            // Files.writeString(path2, " Tomorrow is Monday"); // overwrite existing content

            // appending demo
            Files.writeString(path2, "\nDay After Tomorrow is Tuesday", StandardOpenOption.APPEND);

            System.out.println(" File b.txt updated successfully ");
        } catch (Exception e) {
            System.out.println(" Exception happened " + e.getMessage());
        }

    }

}