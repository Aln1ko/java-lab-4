/*
Створити застосунок для перегляду списку елементів в масиві байтових чисел
і видалення елементів списку. Початкові записи в списку (5 елементів типу Byte)
створюються в програмному коді і є об'єктом класу ArrayList.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ex21 {
    public static void main(String[] args) {
        ArrayList<Byte> byteList = new ArrayList<>();

        byteList.add((byte) 10);
        byteList.add((byte) 20);
        byteList.add((byte) 30);
        byteList.add((byte) 40);
        byteList.add((byte) 50);

        System.out.println("Початковий список байтових чисел:");
        displayList(byteList);

        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 3) {
            // Виведення меню
            System.out.println("\nМеню:");
            System.out.println("1. Додати елемент");
            System.out.println("2. Видалити елемент");
            System.out.println("3. Вийти з програми");
            System.out.println("Виберіть опцію:");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введіть число для додавання:");
                    byte numToAdd;
                    try {
                        numToAdd = scanner.nextByte();
                        byteList.add(numToAdd);
                        System.out.println("Елемент успішно додано.");
                        displayList(byteList);
                    } catch (InputMismatchException e) {
                        System.out.println("Неправильне число.");
                        scanner.nextLine(); // Очистка буфера введення
                    }
                    break;
                case 2:
                    System.out.println("Введіть індекс елемента для видалення:");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < byteList.size()) {
                        byteList.remove(index);
                        System.out.println("Елемент успішно видалено.");
                        displayList(byteList);
                    } else {
                        System.out.println("Неправильний індекс.");
                    }
                    break;
                case 3:
                    System.out.println("Програма завершена.");
                    break;
                default:
                    System.out.println("Неправильний вибір опції.");
                    break;
            }
        }
    }

    private static void displayList(ArrayList<Byte> list) {
        System.out.print("Список байтових чисел:");
        for (Byte element : list) {
            System.out.print(" " + element);
        }
        System.out.println();
    }
}