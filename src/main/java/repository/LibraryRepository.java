package repository;
import models.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class LibraryRepository {
    private final Map<String, Book> allBooks=new HashMap<>();
    private final Map<String,Boolean> availablyBook = new HashMap<>();
    public void addBook(Book book){
        if(book==null)throw new NullPointerException("Book cannot be null");
        allBooks.put(book.isbn(),book);
        availablyBook.put(book.isbn(),true);
    }
    public Optional<Book> findBookByIsbn(String isbn){
        return Optional.of(allBooks.get(isbn));
    }
    public Optional<List<Book>> findBooksByAuthor(String author){
        return Optional.of(allBooks.values()
                .stream()
                .filter(book-> book.author().equals(author))
                .toList());
    }
    public boolean isAvailable(String isbn){
        if(isbn == null)throw new NullPointerException("ISBN cannot be null");
        if(!allBooks.containsKey(isbn)){
            System.out.println("Book not in library");
            return false;
        }
        return availablyBook.get(isbn
        );
    }
    public void changeAvailably(String isbn){
        if(isbn == null)throw new NullPointerException("ISBN cannot be null");
        if(!allBooks.containsKey(isbn))throw new RuntimeException("Book not in library");
        Book book = allBooks.get(isbn);
        boolean availably = availablyBook.get(isbn);
        availablyBook.replace(isbn,!availably);
    }
    public List<Book> findBooksPublishedAfter(int year){
        if(year<0)
            throw new IllegalArgumentException("Year cannot be negative value!");
        return allBooks.values()
                .stream()
                .filter(book-> book.year()>year)
                .toList();
    }
    public Map<String, Long> getBooksCountByAuthor(){
        return allBooks.values()
                .stream()
                .collect(Collectors.groupingBy(
                    Book::author,
                    Collectors.counting()
                ));
    }
}
