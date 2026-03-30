package Files;

import Files.BorrowableItems.Book;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public User findUserById(int id) {
        return users.stream()
                .filter(u -> u.getUserId() == id)
                .findFirst()
                .orElse(null);
    }

    public Book findBookById(int id) {
        return books.stream()
                .filter(b -> b.getBookId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void borrowBook(int userId, int bookId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        book.borrow(user);
    }

    public void returnBook(int userId, int bookId) {
        User user = findUserById(userId);
        Book book = findBookById(bookId);

        book.returnItem(user);
    }

    public void showAvailableBooks() {
        books.stream()
                .filter(Book::isAvailable)
                .forEach(System.out::println);
    }

    public void showUsers() {
        users.stream()
                .forEach(System.out::println);
    }
}
