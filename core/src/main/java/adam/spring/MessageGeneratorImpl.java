package adam.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);
    private final Game game;

    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    @PostConstruct
    public void postConstruct(){

        log.debug("value is : " + game.getNumber());

    }

    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and "+ game.getBiggest()+
                ". Can you guess it ???";
    }

    @Override
    public String getResultMessage() {

        if(game.isGameWon())
            return "You guessed it ! The number was " + game.getNumber();
        else if (game.isGameLost())
            return "You lost. The number was " + game.getNumber();
        else if (!game.isValidNumberRange())
            return "un valid number passed";
        else if (game.getRemainingGuesses() == game.getGuessCount())
            return "First guess ...";
        else{
            String direction = "lower";
            if(game.getGuess() < game.getNumber())
                direction = "higher";

            return direction + "! You have " + game.getRemainingGuesses() + " left ...";
        }

    }
}
