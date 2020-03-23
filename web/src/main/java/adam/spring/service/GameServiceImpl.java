package adam.spring.service;

import adam.spring.Game;
import adam.spring.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    //fields
    private final Game game;
    private final MessageGenerator msgGenerator;

    //constructors
    @Autowired
    public GameServiceImpl(Game game, MessageGenerator msgGenerator){

        this.game = game;
        this.msgGenerator = msgGenerator;

    }

    //init
    @PostConstruct
    public void init(){
        log.info("main message : " + msgGenerator.getMainMessage() + ", "
                + "number value is : " + game.getNumber());
    }


    //public methods
    @Override
    public boolean isGameOver() {

        if(game.isGameLost() || game.isGameWon())
            return true;

        return false;
    }

    @Override
    public String getMainMessage() {
        return msgGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return msgGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int numberOfGuesses) {
        game.setGuess(numberOfGuesses);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }


}
