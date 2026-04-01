package PodstawyOOP;

import PodstawyOOP.Models.BorrowableItems.Book;
import PodstawyOOP.Models.User;

import java.util.Optional;

public class LibraryService {
    private final LibraryRepository repository;

    public LibraryService(LibraryRepository repository) {
        this.repository = repository;
    }

    public void addBook(Book book) {
        repository.addBook(book);
    }

    public void addUser(User user) {
        repository.addUser(user);
    }

    public void showAvailableBooks() {
        repository.findAvailableBooks().forEach(System.out::println);
    }

    public void showUsers() {
        System.out.println(repository.getUsers());
    }

    public void borrowBook(int userId, int bookId) {

        Optional<User> userOptional = repository.findUserById(userId);
        Optional<Book> bookOptional = repository.findBookById(bookId);

        if (userOptional.isEmpty() || bookOptional.isEmpty()) {
            System.out.println("User or book not found.");
            return;
        }

        Book book = bookOptional.get();
        User user = userOptional.get();

        if (!book.isAvailable()) {
            System.out.println("Book is not available");
        } else {
            book.borrow(user);
            book.setAvailable(false);
        }
    }

    public void returnBook(int userId, int bookId) {

        Optional<User> userOptional =  repository.findUserById(userId);
        Optional<Book> bookOptional = repository.findBookById(bookId);

        if (userOptional.isEmpty() || bookOptional.isEmpty()) {
            System.out.println("User or book not found.");
            return;
        }

        Book book = bookOptional.get();
        User user = userOptional.get();
        book.returnItem(user);
    }

    public int getUserId() {
        return repository.generateUserId();
    }

    public int getBookId() {
        return repository.generateBookId();
    }


}
