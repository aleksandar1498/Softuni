package entities.miscellaneous;

import interfaces.InputReader;

import java.util.Scanner;

public class InputReaderImpl implements InputReader {
    Scanner scanner;

    public InputReaderImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
