package PodstawyOOP.Models.BorrowableItems;

import PodstawyOOP.Models.Identifiable;
import PodstawyOOP.Models.User;


public class Book implements Borrowable, Identifiable {
    private final String title;
    private final String  author;
    private final int id;
    private boolean isAvailable;

    @Override
    public String toString() {
        return "Files.BorrowableItems.Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", id=" + id +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public Book(String title, String author, int id, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public void borrow(User user) {
        if (!isAvailable) {
            System.out.println("Files.BorrowableItems.Book unavailable");
            return;
        }

        isAvailable = false;
        user.getBorrowedBooks().add(this);

        System.out.println(user.getName() + " borrowed book " + title);
    }

    @Override
    public void returnItem(User user) {
        isAvailable = true;
        user.getBorrowedBooks().remove(this);

        System.out.println(user.getName() + " returned book " + title);
    }

    @Override
    public int getId() {
        return id;
    }
}
