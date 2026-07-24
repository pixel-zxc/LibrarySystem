package models;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class User {
    private final long id;
    private String name;
    private final Map<String, Book> borrowedBooks = new HashMap();

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public void borrowBook(Book book){
        if(book==null) throw new NullPointerException("Book cannot be null");
        if(borrowedBooks.containsKey(book.isbn())){
            System.out.println("User always borrowed that book");
            return;
        }
        borrowedBooks.put(book.isbn(),book);
    }
    public void returnBook(String isbn){
        if(!borrowedBooks.containsKey(isbn))throw new RuntimeException("User haven't this book");
        borrowedBooks.remove(isbn);
    }
    public Optional<Book> getBookByISBN(String isbn){
        return Optional.of(borrowedBooks.get(isbn));
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Book> getBorrowedBooks() {
        return Collections.unmodifiableMap(borrowedBooks);
    }
}
