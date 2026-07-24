package exception;

public class BookNotAvailablyException extends RuntimeException {
    public BookNotAvailablyException(String isbn) {
        super("Книга с ISBN "+isbn+" недоступна для выдачи");
    }
}
