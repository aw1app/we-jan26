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
        }

    }

}