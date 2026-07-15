package models;

public final class Book{
    private final String tittle;
    private final String author;
    private final int yearOfRelease;
    private final String isbn;
    private boolean available = true;


    public Book(String tittle, String author, int yearOfRelease, String isbn) {
        this.tittle = tittle;
        this.author = author;
        this.yearOfRelease = yearOfRelease;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book[tittle: "+tittle+ ", author: "+author+", yearOfRelease: "+yearOfRelease+", isbn: "+isbn+']';
    }
    @Override
    public int hashCode(){
        return tittle.hashCode()+author.hashCode()+yearOfRelease+isbn.hashCode();
    }
    @Override
    public boolean equals(Object o){
        if(o == this)return true;
        if(o == null || getClass()!=o.getClass())return false;
        Book book = (Book)o;
        return book.isbn.equals(this.isbn) &&
                book.author.equals(this.author) &&
                book.tittle.equals(this.tittle) &&
                book.yearOfRelease == this.yearOfRelease;
    }

    public String getTittle() {
        return tittle;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
