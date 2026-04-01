package PodstawyOOP.Models.BorrowableItems;

import PodstawyOOP.Models.User;

public interface Borrowable {
    void borrow(User user);
    void returnItem(User user);

}
