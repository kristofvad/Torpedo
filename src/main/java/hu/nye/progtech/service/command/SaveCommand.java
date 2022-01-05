package hu.nye.progtech.service.command;

import hu.nye.progtech.repo.GameSavesRepository;
import hu.nye.progtech.saves.GameState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Saving the state of the game.
 */
public class SaveCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveCommand.class);
    private static final String SAVE_COMMAND = "save";

    private GameSavesRepository gameSavesRepository;
    private GameState gameState;

    public SaveCommand(GameSavesRepository gameSavesRepository, GameState gameState) {
        this.gameSavesRepository = gameSavesRepository;
        this.gameState = gameState;
    }

    @Override
    public boolean canProcess(String input) {
        return SAVE_COMMAND.equals(input);
    }

    @Override
    public void process(String input) {
        LOGGER.debug("Game Save command was called");
        gameSavesRepository.save(gameState.getCurrentMap());
        LOGGER.info("Game Save was successfully persisted");
    }
}
