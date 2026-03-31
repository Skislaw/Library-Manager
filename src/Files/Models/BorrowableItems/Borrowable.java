package Files.Models.BorrowableItems;

import Files.Models.User;

public interface Borrowable {
    void borrow(User user);
    void returnItem(User user);

}
