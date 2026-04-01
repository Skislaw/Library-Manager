package PodstawyOOP;

public class Main {
    public static void main(String[] args) {
        LibraryRepository repo = new LibraryRepository();
        LibraryService service = new LibraryService(repo);
        CLIHelper cliHelper = new CLIHelper();
        CLIManager cliManager = new CLIManager(repo, service, cliHelper);

        cliManager.runner();
    }
}
