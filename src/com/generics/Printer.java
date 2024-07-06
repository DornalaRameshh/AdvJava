package com.generics;

public class Printer <T,V > {
    T typePrinter;
    V text;

    public Printer(T typePrinter, V text) {
        this.typePrinter = typePrinter;
        this.text = text;
    }

    public void print() {
        System.out.println(typePrinter);
        System.out.println(text);
    }

    public static void main(String[] args) {

        Printer<Integer, String> printer = new Printer<>(1, "hhg");
        printer.print();
        Integer[] intArray = {1, 2, 3, 4, 5};
        printArray(intArray);  // Output: 1 2 3 4 5

        // String array
        String[] stringArray = {"Hello", "World", "!"};
        printArray(stringArray);  // Output: Hello World !



    }

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

}
