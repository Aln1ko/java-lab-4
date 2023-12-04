import java.util.Random;
import java.util.Scanner;

/*
Створити застосунок для покупки продуктів в магазині з доставкою.
 Початкові записи в списку продуктів (5 записів) створюються в програмному коді
 і є об'єктом класу HashMap. Ключем запису є артикул продукту (типу Integer),
 а значенням - об'єкт Article, що містить найменування продукту (типу String)
 і ціну товару (типу float).Передбачити можливість перевірки унікальності
  найменування товару за допомогою TreeSet.

 */
public class ex15 {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String input;

        for(int i = 0; i < 5 ; i++){
            shop.add(i,"name" + i, random.nextDouble(10)+1);
        }

        shop.print();
        System.out.println();
        while (true) {
            System.out.println("Enter key, name , price");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.print("Quiting the program\n");
                break;
            }

            String[] words = input.split(" ");

            if(words.length != 3){
                System.out.println("Invalid input.Try again");
                continue;
            }
            try {
                int priority = Integer.parseInt(words[0]);
            }
            catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input format. Please try again.");
                continue;
            }
            try {
                double someDouble = Double.parseDouble(words[2]);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input format or array index. Please try again.");
                continue;
            }
            shop.add(Integer.parseInt(words[0]), words[1], Double.parseDouble(words[2]));
            shop.print();
            System.out.println();
        }
    }
}
