import models.Book;
import models.User;
import repository.LibraryRepository;
import service.LibraryService;

public class Main {
    public static void main(String[] args) {
        Book b = new Book("War and peace","Lev Tolstoy",1862,"1");
        LibraryRepository repository = new LibraryRepository();
        repository.addBook(b);
        LibraryService service = new LibraryService(repository);
        User user = new User(1,"Yatoro");
        service.borrowBook("1", user);

    }
}
