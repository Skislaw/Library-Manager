package Files.BorrowableItems;

import Files.User;

public interface Borrowable {
    void borrow(User user);
    void returnItem(User user);
}
