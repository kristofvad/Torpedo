package hu.nye.progtech.configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import hu.nye.progtech.game.Game;
import hu.nye.progtech.service.command.InputHandler;
import hu.nye.progtech.service.gamestep.GameStepPerformer;
import hu.nye.progtech.service.input.UserInputReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Add.
 */
@Configuration
public class ApplicationConfiguration {

    @Bean(initMethod = "game")
    public Game torpedo() {
      return new Game();
    }

    @Bean
    GameStepPerformer gameStepPerformer(UserInputReader userInputReader, InputHandler inputHandler) {
        return new GameStepPerformer(userInputReader, inputHandler);
    }

    @Bean
    UserInputReader userInputReader() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return new UserInputReader(bufferedReader);
    }


}
