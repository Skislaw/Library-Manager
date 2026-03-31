package Files;

public class Main {
    void main() {
        LibraryRepository repo = new LibraryRepository();
        LibraryService service = new LibraryService(repo);
        CLIManager cliManager = new CLIManager(repo, service);

        cliManager.runner();
    }
}
