package adam.spring.console;

import adam.spring.Game;
import adam.spring.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess {

    //fields
    private final Game game;
    private final MessageGenerator msgGenerator;

    //constructors
    @Autowired
    public ConsoleNumberGuess(Game game, MessageGenerator msgGenerator) {
        this.game = game;
        this.msgGenerator = msgGenerator;
    }

    //events
    @EventListener
    public void start(ContextRefreshedEvent contextRefreshedEvent) {

        log.info(" START Container ready for use.");

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println(msgGenerator.getMainMessage());
            System.out.println(msgGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                System.out.println(msgGenerator.getResultMessage());
                System.out.println("Play again y/n ???");

                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("y"))
                    break;

                game.reset();

            }

        }

    }




}
