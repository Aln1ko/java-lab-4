/*
Створити застосунок для пошуку книг в бібліотечному каталозі по заданому критерію.
Початкові записи в списку книг (5 записів) створюються в програмному коді і
є об'єктом класу HashMap. Ключем записи є індекс ISBN книги (типу Integer),
а значенням - об'єкт Book, що містить найменування книги, прізвище, ім'я та по
батькові (ПІБ) учасника, видавництво (всі записи типу String), рік видання (типу int)
і ціну книги (типу float). Передбачити можливість сортування каталогу по ПІБ
автора або роком видання, для чого використовувати ArrayList.
Передбачити можливість перевірки унікальності книги за допомогою TreeSet.
 */

import java.util.*;

class Book{
    private String bookName;
    private String authorName;
    private String authorSurname;
    private String authorMiddleName;
    private String publishingHouse;
    private int year;
    private double price;

    Book()
    {
        bookName ="bookName1";
        authorName = "authorName1";
        authorSurname = "authorSurname1";
        authorMiddleName = "authorMiddleName1";
        publishingHouse = "publishingHouse1";
        year = 2018;
        price = 146.99;
    }
    public Book(String bookName, String authorName, String authorSurname,
     String authorMiddleName,String publishingHouse, int year, double price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.authorMiddleName = authorMiddleName;
        this.publishingHouse = publishingHouse;
        this.year = year;
        this.price = price;
    }

    public String toString() {
        return "Title: " + bookName + ", Author: " + authorName +" " + authorSurname + " "
                + authorMiddleName + ", publishingHouse: " + publishingHouse
                + ", Publication Year: " + year + ", Price: " + price;
    }

    public static Comparator<Book> authorComparator = Comparator
            .comparing(Book::getAuthorSurname)
            .thenComparing(Book::getAuthorName)
            .thenComparing(Book::getAuthorMiddleName);

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthorMiddleName() {
        return authorMiddleName;
    }

    public void setAuthorMiddleName(String authorMiddleName) {
        this.authorMiddleName = authorMiddleName;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
}

class LibraryCatalog{
    private HashMap<Integer,Book> map;
    private TreeSet<String> uniqueBook;
    private ArrayList<Book> list;

    public LibraryCatalog(){
        map = new HashMap<>();
        uniqueBook = new TreeSet<>();
        list = new ArrayList<>();
    }

    public void sortByAuthor() {
        Collections.sort(list, Book.authorComparator);
    }
    public void sortByYear() {
        Collections.sort(list, Comparator.comparingInt(Book::getYear));
    }


    public List<Book> searchByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        for (Book book : list) {
            if ((book.getAuthorName()+book.getAuthorSurname()+book.getAuthorMiddleName()).equalsIgnoreCase(authorName)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByPublicationYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : list) {
            if (book.getYear() == year) {
                result.add(book);
            }
        }
        return result;
    }

    public void addBook(int isbn, Book book) {
        if (!uniqueBook.contains(book.getBookName()+
                book.getAuthorName()+book.getAuthorSurname()+
                book.getAuthorMiddleName())) {
            map.put(isbn, book);
            uniqueBook.add(book.getBookName()+
                    book.getAuthorName()+book.getAuthorSurname()+
                    book.getAuthorMiddleName());
            list.add(book);
        }
    }

    public void printCatalog() {
        for (Book book : map.values()) {
            System.out.println(book);
        }
    }
    public void printList(){
        for(Book book : list){
            System.out.println(book);
        }
    }


}


public class ex17 {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String input;

        for(int i = 0; i < 5; i++){
            Book book = new Book();
            book.setBookName(book.getBookName()+i);
            book.setAuthorName(book.getAuthorName()+i);
            book.setAuthorSurname(book.getAuthorSurname()+i);
            book.setAuthorMiddleName(book.getAuthorMiddleName()+i);
            book.setPrice(random.nextDouble(70)+100);
            book.setYear(random.nextInt(23)+2000);
            catalog.addBook(i,book);
        }
        int isbn = 5 ;

        catalog.printList();
        System.out.println();


        while (true) {
            System.out.println("1. Add book ");
            System.out.println("2. Sort by Author ");
            System.out.println("3. Sort by Year  ");
            System.out.println("4. Exit ");
            input = scanner.nextLine();

            if(input.length()!= 1){
                System.out.println("Invalid input.Try again");
                continue;
            }

            if (input.equalsIgnoreCase("4")) {
                System.out.print("Quiting the program\n");
                break;
            }

            if(input.equalsIgnoreCase("1")){
                while(true){
                    System.out.println("Enter book name and author name");
                    input = scanner.nextLine();
                    String[] words = input.split(" ");

                    if(words.length != 2){
                        System.out.println("Invalid input.Try again");
                        continue;
                    }

                    Book book1 = new Book();
                    book1.setBookName(words[0]);
                    book1.setAuthorName(words[1]);
                    catalog.addBook(isbn,book1);
                    isbn++;
                    break;
                }
                catalog.printCatalog();
                System.out.println();
            }

            if(input.equalsIgnoreCase("2")){
                catalog.sortByAuthor();
                catalog.printList();
                System.out.println();
            }
            if(input.equalsIgnoreCase("3")){
                catalog.sortByYear();
                catalog.printList();
                System.out.println();
            }
        }
    }
}

