package org.example;

public class Main {
    public static void main(String[] args) {
        try {

        } catch (NumberFormatException e) {
            System.out.printf("Entra Inválida, Tente novamente. Error: (" + e.getMessage() + ")");
        }
    }
}