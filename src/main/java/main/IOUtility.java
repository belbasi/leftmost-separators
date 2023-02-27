package main;

import java.io.File;
import java.io.FileNotFoundException;

public class IOUtility {

    public static void readFromFile(String path) {
        try {
            File input = new File(path);
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the file in " +path);
        }
    }
}
