import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;

public class FileAPIDemo {

    public static void main(String[] args) {

       // Path path1 = Path.of("a.txt");

        File f1 = new File("a.txt"); ; //new File("a1.txt");

        // Check if the file exist
        System.out.println(" f1.getAbsolutePath() " + f1.getAbsolutePath()); //
        System.out.println(" f1.exists() " + f1.exists()); // true
        System.out.println(" f1.length() " + f1.length()); // 11
        System.out.println(" f1.isFile() " + f1.isFile()); // true

        //Folders operation
        File folder1 = new File("F:\\Users\\home\\git\\we-jan26\\PHASE3\\FileIO");
        // check if this folder exist
        System.out.println(" folder1.getAbsolutePath() " + folder1.getAbsolutePath()); // true
        System.out.println(" folder1.exists() " + folder1.exists()); // true
        System.out.println(" folder1.isFile() " + folder1.isFile()); // false
    }

}