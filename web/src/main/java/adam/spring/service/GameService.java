package adam.spring.service;

public interface GameService {

    boolean isGameOver();
    String getMainMessage();
    String getResultMessage();
    void checkGuess(int numberOfGuesses);
    void reset();

}
