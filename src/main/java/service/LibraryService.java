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
//    public boolean isAvailably(String isbn){
//        if(isbn==null)return false;
//        return repository.isAvailable(isbn);
//    }
    public boolean borrowBook(String isbn, User user){
        if(isbn ==null){
            System.out.println("ISBN cannot ba a null");
            return false;
        }
        if(user == null){
            System.out.println("User cannot ba a null");
            return false;
        }
        Optional<Book> optionalBook = repository.findBookByIsbn(isbn);
        if(optionalBook.isEmpty()) {
            System.out.println("Book is not in library");
            return false;
        }
        if(!repository.isAvailable(isbn)) {
            System.out.println("Book is not availably");
            return false;
        }
        Book book = optionalBook.get();
        user.borrowBook(book);
        changeAvailably(book);
        return true;
    }
    public boolean returnBook(String isbn, User user){
        if(isbn ==null){
            System.out.println("ISBN cannot ba a null");
            return false;
        }
        if(user == null){
            System.out.println("User cannot ba a null");
            return false;
        }
        Optional<Book> optionalBook = user.getBookByISBN(isbn);
        if(optionalBook.isEmpty()){
            System.out.println("User don't borrowed this book");
            return false;
        }
        Book book = optionalBook.get();
        user.returnBook(isbn);
        changeAvailably(book);
        return true;
    }
    private void changeAvailably(Book book){
        try{
            repository.changeAvailably(book.getIsbn());
        }catch (NullPointerException e){
            System.out.println("book don't have a ISBN!");
        }catch (RuntimeException e){
            System.out.println("Book can't be in Library!");
        }
    }
}
