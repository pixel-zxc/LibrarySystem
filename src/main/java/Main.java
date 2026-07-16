import models.Book;
import models.User;
import repository.LibraryRepository;
import service.LibraryService;

public class Main {
    public static void main(String[] args) {
        Book b = new Book("War and peace","Lev Tolstoy",1862,"1");
        Book b1 = new Book("Another book","Lev Tolstoy",1863,"2");
        LibraryRepository repository = new LibraryRepository();
        repository.addBook(b);
        repository.addBook(b1);
        LibraryService service = new LibraryService(repository);
        User user = new User(1,"Yatoro");
        User user1 = new User(2,"Durachie");
        service.borrowBook("1", user);
        service.borrowBook("2",user);
        service.borrowBook("2",user1);
        service.returnBook("1",user);


    }
}
