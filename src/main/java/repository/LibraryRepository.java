package repository;
import models.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class LibraryRepository {
    private final Map<String, Book> allBooks=new HashMap<>();
    public void addBook(Book book){
        if(book==null)throw new NullPointerException("Book cannot be null");
        allBooks.put(book.getIsbn(),book);
    }
    public Optional<Book> findBookByIsbn(String isbn){
        return Optional.of(allBooks.get(isbn));
    }
    public Optional<List<Book>> findBooksByAuthor(String author){
        return Optional.of(allBooks.values()
                .stream()
                .filter(book-> book.getAuthor().equals(author))
                .toList());
    }
    public boolean isAvailable(String isbn){
        if(isbn == null)throw new NullPointerException("ISBN cannot be null");
        if(!allBooks.containsKey(isbn))return false;
        return allBooks.get(isbn).isAvailable();
    }


}
