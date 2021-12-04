package hu.nye.progtech.configuration;

import hu.nye.progtech.Game;
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

}
