package PodstawyOOP.Models;

import PodstawyOOP.Models.BorrowableItems.Book;
import java.util.ArrayList;
import java.util.List;

public class User implements Identifiable {
    private final String name;
    private final String surname;
    private final int age;
    private final int id;
    List<Book> books = new ArrayList<>();
    List<Book> borrowedBooks = new ArrayList<>();

    @Override
    public String toString() {
        return "Files.User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", UserId=" + id +
                ", books=" + books +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }

    public User(String name, String surname, int age, int userId, List<Book> books) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        id = userId;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public int getId() {
        return id;
    }
}
