package service;

import models.User;
import repository.LibraryRepository;
import models.Book;
import java.util.List;
import java.util.Optional;

public class LibraryService {
    private final LibraryRepository repository;

    public LibraryService(LibraryRepository repository) {
        this.repository = repository;
    }
    public boolean addBook(Book book){
        if(book == null)return false;
        repository.addBook(book);
        return true;
    }
    public List<Book> findAllBooksByAuthor(String author){
        if(author==null) return List.of();
        return repository.findBooksByAuthor(author).orElse(List.of());
    }
    public boolean isAvailably(String isbn){
        if(isbn==null)return false;
        return repository.isAvailable(isbn);
    }
    public boolean borrowBook(String isbn, User user){
        Optional<Book> optionalBook = repository.findBookByIsbn(isbn);
        if(optionalBook.isEmpty())return false;
        Book book = optionalBook.get();
        user.borrowBook(book);
        return true;
    }
}
