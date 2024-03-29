package hu.nye.progtech.service.command;

import hu.nye.progtech.saves.GameState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command used to exit from the game.
 */
public class ExitCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExitCommand.class);
    private static final String EXIT_COMMAND = "exit";

    private final GameState gameState;

    public ExitCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public boolean canProcess(String input) {
        return EXIT_COMMAND.equals(input);
    }

    @Override
    public void process(String input) {
        LOGGER.info("Performing exit command");
        gameState.setShouldExit(true);
    }

}
