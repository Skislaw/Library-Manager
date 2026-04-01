package PodstawyOOP;

import java.util.Scanner;

public class CLIHelper {
    private final Scanner scanner = new Scanner(System.in);

    public int readInt(String message) {

        System.out.println(message);
        try {
            return  Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }


}
