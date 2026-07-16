package models;

import java.util.Objects;

public final class Book{
    private final String title;
    private final String author;
    private final int yearOfRelease;
    private final String isbn;



    public Book(String tittle, String author, int yearOfRelease, String isbn) {
        this.title = tittle;
        this.author = author;
        this.yearOfRelease = yearOfRelease;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book[tittle: "+title+ ", author: "+author+", yearOfRelease: "+yearOfRelease+", isbn: "+isbn+']';
    }
    @Override
    public int hashCode(){
        return title.hashCode()+author.hashCode()+yearOfRelease+isbn.hashCode();
    }
    @Override
    public boolean equals(Object o){
        if(o == this)return true;
        if(o == null || getClass()!=o.getClass())return false;
        Book book = (Book)o;
        return Objects.equals(book,this);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public String getIsbn() {
        return isbn;
    }
}
