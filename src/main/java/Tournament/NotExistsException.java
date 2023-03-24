package Tournament;

public class NotExistsException extends RuntimeException {
    public NotExistsException(String playerName) {
        super("Игрок " + playerName + "не найден");
    }
}
