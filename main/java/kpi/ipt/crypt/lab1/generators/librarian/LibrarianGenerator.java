package main.java.kpi.ipt.crypt.lab1.generators.librarian;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Roman Horilyi on 27.09.2016.
 */
public class LibrarianGenerator {
    private ArrayList<Integer> generatedRandomNumbers;
    private String filePath;

    public LibrarianGenerator(String filePath) {
        generatedRandomNumbers = new ArrayList<>();
        this.filePath = filePath;
    }

    public void generateRandomNumbers() {
        try (InputStream inputStream = Files.newInputStream(Paths.get(filePath))) {
            int byteOfText = inputStream.read();
            while (byteOfText != -1) {
                generatedRandomNumbers.add(byteOfText);
                byteOfText = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getRandomNumbers() {
        return generatedRandomNumbers;
    }

    public void printRandomNumbers() {
        for (int random : getRandomNumbers()) {
            System.out.print(random + " ");
        }
    }
}
