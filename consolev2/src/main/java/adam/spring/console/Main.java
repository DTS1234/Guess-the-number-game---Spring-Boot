package adam.spring.console;

import adam.spring.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    //private static final String CONFIG_LOCATION =  "beans.xml";

    public static void main(String[] args) {
        log.info("Guess number game");

        // create context (container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(GameConfig.class);

        // close context container
        context.close();
    }

}
