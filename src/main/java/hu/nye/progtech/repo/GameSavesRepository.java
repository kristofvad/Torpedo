package hu.nye.progtech.repo;


import hu.nye.progtech.game.Map;

/**
 * Interface for storing and retrieving current Torpedo game states.
 */
public interface GameSavesRepository {

    void save(Map currentMap);

    Map load();

}
