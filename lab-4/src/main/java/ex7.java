/*
Створити застосунок для перегляду списку черговиків.
 Початкові записи в списку (5 записів) створюються в програмному коді
  і є об'єктом класу LinkedList. Запис списку є об'єктом QueuePerson,
   що містить поля прізвища, імені та по батькові черговика (типу String),
   поле типу AddressValue для адреси черговика і пріоритет черговика (типу int).
   У свою чергу, поле типу AddressValue містить три поля типу String:
   найменування міста, найменування вулиці та номер будинку, а також поле типу int
    - номер квартири (якщо номер квартири дорівнює 0, будинок, в якому проживає
    суб'єкт, не має квартир). Записи в черзі мають бути упорядковані
    відповідно до пріоритету і черговик додається останнім в чергу свого пріоритету.
     Забезпечити, щоб в черзі не було повторення по ПІБ черговика, для чого
     використовувати TreeSet.
 */

import java.util.*;

public class ex7 {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String input;

        for(int i = 0; i < 5 ; i ++)
        {
            QueuePerson person = new QueuePerson();
            int priority = random.nextInt(3)+1;
            person.setPriority(priority);
            person.setName(person.getName()+i);
            person.setSurname(person.getSurname()+i);
            person.setMiddleName(person.getMiddleName()+i);
            queue.add(person);
        }
        queue.print();
        System.out.println();

        while (true){
            System.out.print("Enter prioprity int from 1 to 3,name,surname,middle name or q to quit ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                System.out.print("Quiting the program\n");
                break;
            }
            String[] words = input.split(" ");
            if(words.length < 4 || words.length > 4){
                System.out.println("Invalid input.Try again");
                continue;
            }

            try {
                int priority = Integer.parseInt(words[0]);
                if (priority < 1 || priority > 3) {
                    System.out.println("Priority should be an integer between 1 and 3. Please enter again.");
                    continue;
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input format. Please try again.");
                continue;
            }
            QueuePerson person = new QueuePerson();
            person.setPriority(Integer.parseInt(words[0]));
            person.setName(words[1]);
            person.setSurname(words[2]);
            person.setMiddleName(words[3]);
            queue.add(person);

            queue.print();
            System.out.println();
        }
    }
}
