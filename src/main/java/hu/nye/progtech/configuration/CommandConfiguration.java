package hu.nye.progtech.configuration;

import java.util.List;

import hu.nye.progtech.repo.GameSavesRepository;
import hu.nye.progtech.saves.GameState;
import hu.nye.progtech.service.command.Command;
import hu.nye.progtech.service.command.ExitCommand;
import hu.nye.progtech.service.command.InputHandler;
import hu.nye.progtech.service.command.LoadCommand;
import hu.nye.progtech.service.command.SaveCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * Spring Java configuration class for command specific Spring Beans.
 */
@Configuration
public class CommandConfiguration {


    @Bean
    InputHandler inputHandler(List<Command> commandList) {
        return new InputHandler(commandList);
    }

    @Bean
    SaveCommand saveCommand(GameSavesRepository gameSavesRepository, GameState gameState) {
        return new SaveCommand(gameSavesRepository, gameState);
    }

    @Bean
    LoadCommand loadCommand(GameSavesRepository gameSavesRepository, GameState gameState) {
        return new LoadCommand(gameSavesRepository, gameState);
    }

    @Bean
    ExitCommand exitCommand(GameState gameState) {
        return new ExitCommand(gameState);
    }
}
