package PodstawyOOP;

import PodstawyOOP.Models.BorrowableItems.Book;
import PodstawyOOP.Models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibraryRepository {
    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return List.copyOf(users);
    }

    public Optional<User> findUserById(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }

    public Optional<Book> findBookById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<Book> findAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .toList();
    }

    public int generateUserId() {
        return users.size() + 1;
    }

    public int generateBookId() {
        return books.size() + 1;
    }
}
