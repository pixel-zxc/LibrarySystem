import exception.BookNotAvailablyException;
import models.Book;
import models.User;
import repository.LibraryRepository;
import service.LibraryService;

public class Main {
    public static void main(String[] args) {
        Book b = new Book("War and peace","Lev Tolstoy",1862,"1");
        Book b1 = new Book("Another book","Lev Tolstoy",1863,"2");
        Book b3 = new Book("One more another book","Lev Tolstoy",1865,"3");
        Book b4 = new Book("Evgeniy Onegin","Alex Pushkin",1466,"4");

        LibraryRepository repository = new LibraryRepository();

        repository.addBook(b);
        repository.addBook(b1);
        repository.addBook(b3);
        repository.addBook(b4);

        LibraryService service = new LibraryService(repository);

        User user = new User(1, "Yatoro");
        User user1 = new User(2, "Durachie");

        try {
            service.borrowBook("1", user);
            service.borrowBook("2", user);
            service.borrowBook("2", user1);
            service.returnBook("1", user);
        }catch (BookNotAvailablyException bookExc){
            System.out.println("Book is not availably");
        }

        service.findBooksPublisherAfter(1862);
    }
}
