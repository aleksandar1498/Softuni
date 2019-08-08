package cresla.entities;

import cresla.interfaces.InputReader;

import java.util.Scanner;

public class InputReaderImpl implements InputReader {
    private Scanner scanner;

    public InputReaderImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
