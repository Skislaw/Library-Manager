package Files;

import Files.Models.BorrowableItems.Book;
import Files.Models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class CLIManager {
    private final LibraryRepository libraryRepository = new LibraryRepository();
    private final LibraryService libraryService = new LibraryService(libraryRepository);

    public CLIManager(LibraryRepository libraryRepository, LibraryService libraryService) {
    }

    void runner() {

        boolean shouldContinue;
        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME TO LIBRARY MANAGER");

        shouldContinue = true;

        while (shouldContinue) {

            System.out.print("> ");
            String userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case "addbook" -> {
                    System.out.println("Enter title: ");String title = scanner.nextLine();
                    System.out.println("Enter author: ");String author = scanner.nextLine();
                    Book book = new Book(title, author, libraryRepository.getBooks().size(), true);
                    libraryRepository.addBook(book);
                    System.out.println("Book '" + title + "' by " + author + " has been added.");
                }
                case "adduser" -> {
                    System.out.println("Enter name: ");String name = scanner.nextLine();
                    System.out.println("Enter surname: ");String surname = scanner.nextLine();
                    System.out.println("Enter age: ");int age = Integer.parseInt(scanner.nextLine());
                    User user = new User(name, surname, age, libraryRepository.getUsers().size(), new ArrayList<>());
                    libraryRepository.addUser(user);
                    System.out.println("User " + name + " " + surname + " has been added.");
                }
                case "borrowbook" -> {
                    int userId = readInt("Enter user id: ");
                    int bookId = readInt("Enter book id: ");
                    libraryService.borrowBook(userId, bookId);
                }
                case "returnbook" -> {
                    int userId = readInt("Enter user id: ");
                    int bookId = readInt("Enter book id: ");
                    libraryService.returnBook(userId, bookId);
                }
                case "sb" -> libraryService.showAvailableBooks();
                case "showusers" -> libraryService.showUsers();
                case "exit" -> shouldContinue = false;
                case "help" -> System.out.println("Commands: addbook, adduser, borrowbook, returnbook, showavailablebooks, showusers, exit");
                default -> System.out.println("Unknown command. Type 'help' for help");
            }
        }
    }

    int readInt(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);
        try {
            return  Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
