package models;

import java.util.Objects;

public record Book(
        String title,
        String author,
        int year,
        String isbn
){


    @Override
    public String toString() {
        return "Book[title: "+title+ ", author: "+author+", year: "+year+", isbn: "+isbn+']';
    }



}
