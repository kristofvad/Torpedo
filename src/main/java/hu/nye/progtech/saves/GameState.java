package hu.nye.progtech.saves;

import java.util.Objects;

import hu.nye.progtech.game.Map;

/**
 * The actual state of the game.
 */
public class GameState {
    public static GameStateBuilder builder() {
        return new GameStateBuilder();
    }

    private String username;
    private Map currentMap;
    private boolean shouldExit;

    /**
     * Constructor for GameState.
     */
    public GameState(String username, Map currentMap, boolean shouldExit) {
        this.username = username;
        this.currentMap = currentMap;
        this.shouldExit = shouldExit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Map currentMap) {
        this.currentMap = currentMap;
    }

    public boolean isShouldExit() {
        return shouldExit;
    }

    public void setShouldExit(boolean shouldExit) {
        this.shouldExit = shouldExit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameState gameState = (GameState) o;
        return shouldExit == gameState.shouldExit && Objects.equals(username, gameState.username)
                && Objects.equals(currentMap, gameState.currentMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, currentMap, shouldExit);
    }

    /**
     * Builder for {@link GameState}.
     */
    public static final class GameStateBuilder {
        private String username;
        private Map currentMap;
        private boolean shouldExit;

        private GameStateBuilder() {
        }

        public static GameStateBuilder builder() {
            return new GameStateBuilder();
        }

        public GameStateBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public GameStateBuilder withCurrentMap(Map currentMap) {
            this.currentMap = currentMap;
            return this;
        }

        public GameStateBuilder withShouldExit(boolean shouldExit) {
            this.shouldExit = shouldExit;
            return this;
        }

        public GameState build() {
            return new GameState(username, currentMap, shouldExit);
        }
    }
}

