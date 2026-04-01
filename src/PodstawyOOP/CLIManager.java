package PodstawyOOP;

import PodstawyOOP.Models.BorrowableItems.Book;
import PodstawyOOP.Models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class CLIManager {
    private final LibraryRepository libraryRepository;
    private final LibraryService libraryService;
    private final CLIHelper cliHelper;
    private final Scanner scanner = new Scanner(System.in);

    public CLIManager(LibraryRepository libraryRepository, LibraryService libraryService, CLIHelper cliHelper) {
        this.libraryService = libraryService;
        this.libraryRepository = libraryRepository;
        this.cliHelper = cliHelper;
    }

    void runner() {

        boolean shouldContinue;
        System.out.println("WELCOME TO LIBRARY MANAGER");

        shouldContinue = true;

        while (shouldContinue) {

            System.out.print("> ");
            String userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case "addbook" -> {
                    System.out.println("Enter title: ");String title = scanner.nextLine();
                    System.out.println("Enter author: ");String author = scanner.nextLine();
                    Book book = new Book(title, author, libraryService.getBookId(), true);
                    libraryService.addBook(book);
                    System.out.println("Book '" + title + "' by " + author + " has been added.");
                }
                case "adduser" -> {
                    System.out.println("Enter name: ");String name = scanner.nextLine();
                    System.out.println("Enter surname: ");String surname = scanner.nextLine();
                    int age = cliHelper.readInt("Enter age: ");

                    if (age <=0 || age >150) {
                        System.out.println("Incorrect age");
                        break;
                    }

                    User user = new User(name, surname, age, libraryService.getUserId(), new ArrayList<>());
                    libraryService.addUser(user);
                    System.out.println("User " + name + " " + surname + " has been added.");
                }
                case "borrowbook" -> {
                    int userId = cliHelper.readInt("Enter user id: ");
                    int bookId = cliHelper.readInt("Enter book id: ");
                    libraryService.borrowBook(userId, bookId);
                }
                case "returnbook" -> {
                    int userId = cliHelper.readInt("Enter user id: ");
                    int bookId = cliHelper.readInt("Enter book id: ");
                    libraryService.returnBook(userId, bookId);
                }
                case "showavailablebooks" -> libraryService.showAvailableBooks();
                case "showusers" -> libraryService.showUsers();
                case "exit" -> shouldContinue = false;
                case "help" -> System.out.println("Commands: addbook, adduser, borrowbook, returnbook, showavailablebooks, showusers, exit");
                default -> System.out.println("Unknown command. Type 'help' for help");
            }
        }
    }
}
