package live.kavinduj.theserenitymhtc.exeception;

public class MissingFieldException extends RuntimeException {
    public MissingFieldException(String message) {
        super(message);
    }
}
