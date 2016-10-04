package main.java.kpi.ipt.crypt.lab1.generators.librarian;

import main.java.kpi.ipt.crypt.lab1.generators.StreamingGenerator;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Roman Horilyi on 27.09.2016.
 */
public class LibrarianGenerator extends StreamingGenerator {
    private String filePath;

    public LibrarianGenerator(String filePath) {
        this.filePath = filePath;
    }

    public void generateRandomNumbers() {
        ArrayList<Integer> randoms = convertTextIntoBytes();
        randoms.forEach(this::addToGeneratedRandomNumbers);
    }

    private ArrayList<Integer> convertTextIntoBytes() {
        ArrayList<Integer> bytesOfText = new ArrayList<>();
        try (InputStream inputStream = Files.newInputStream(Paths.get(filePath))) {
            int byteOfText = inputStream.read();
            while (byteOfText != -1) {
                bytesOfText.add(byteOfText);
                byteOfText = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytesOfText;
    }

    @Override
    public void generateRandomNumbers(int quantity) {
        ArrayList<Integer> randoms = convertTextIntoBytes();
        int counter = 0;
        for (int random : randoms) {
            addToGeneratedRandomNumbers(random);
            if (++counter == quantity) {
                return;
            }
        }
    }
}
