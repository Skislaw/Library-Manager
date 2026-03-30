import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    Library library = new Library();
    boolean shouldContinue;

    void runner() {

        System.out.println("WELCOME TO LIBRARY MANAGER");

        shouldContinue = true;

        while (shouldContinue) {

            System.out.print("> ");
            String userInput = scanner.nextLine();
            userInput.toLowerCase();

            switch (userInput) {
                case "addbook" -> {
                    System.out.println("Enter title: ");
                    String title = scanner.nextLine();

                    System.out.println("Enter author: ");
                    String author = scanner.nextLine();

                    Book book = new Book(title, author, library.getBooks().size(), true);
                    library.addBook(book);

                    System.out.println("Book '" + title + "' by " + author + " has been added.");
                }

                case "adduser" -> {
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter surname: ");
                    String surname = scanner.nextLine();

                    System.out.println("Enter your age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();     //"eating" next line sign left by nextInt

                    User user = new User(name, surname, age, library.getUsers().size(), new ArrayList<>());
                    library.addUser(user);

                    System.out.println("User " + name + " " + surname + " has been added.");
                }

                case "borrowbook" -> {
                    System.out.println("Enter book id: ");
                    int enteredBookId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter user id: ");
                    int enteredUserId = scanner.nextInt();
                    scanner.nextLine();

                    int bookId = library.findBookById(enteredBookId).getBookId();
                    int userId = library.findUserById(enteredUserId).getUserId();

                    if (userId < 0 || bookId < 0) {
                        System.out.println("User or book not found.");
                        break;
                    }

                    library.borrowBook(userId, bookId);

                }
                case "returnbook" -> {

                    System.out.println("Enter book id: ");
                    int enteredBookId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter user id: ");
                    int enteredUserId = scanner.nextInt();
                    scanner.nextLine();

                    int bookId = library.findBookById(enteredBookId).getBookId();
                    int userId = library.findUserById(enteredUserId).getUserId();

                    if (userId < 0 || bookId < 0) {
                        System.out.println("User or book not found.");
                        break;
                    }

                    library.returnBook(userId, bookId);
                }
                case "showavailablebooks" -> library.showAvailableBooks();

                case "showusers" -> library.showUsers();

                case "exit" -> {
                    System.out.println("Are you sure(y/n)?");
                    userInput = scanner.nextLine();

                    if (userInput.equals("y")) {
                        System.out.println("Quitting...");
                        shouldContinue = false;
                    } else if (userInput.equals("n")) {
                        break;
                    }
                }

                case "help" -> {
                    System.out.println("addbook -> Adds book");
                    System.out.println("adduser -> Adds user");
                    System.out.println("borrowbook -> Borrows book");
                    System.out.println("returnbook -> Returns book");
                    System.out.println("showavailablebooks -> Displays list of available books");
                    System.out.println("showusers -> Displays list of users");
                    System.out.println("exit -> Exits the program");
                }

                default -> System.out.println("Unknown command. Type 'help' for help");
            }
        }
        scanner.close();
    }
}
