package models;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
        borrowedBooks.put(book.getIsbn(),book);
    }
    public void returnBook(String isbn){
        if(!borrowedBooks.containsKey(isbn))throw new RuntimeException("User haven't this book");
        borrowedBooks.remove(isbn);
    }
    //#TODO
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
