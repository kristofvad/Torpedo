package hu.nye.progtech.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import hu.nye.progtech.persistence.impl.XmlGameSavesRepository;
import hu.nye.progtech.repo.GameSavesRepository;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * Configuration for xml.
 */
@Configuration
public class RepositoryConfiguration  {

        @Bean
        Connection connection() throws SQLException {
            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        }

        /*

        @Bean(destroyMethod = "close")
        GameSavesRepository jdbcGameSavesRepository(Connection connection, MapToStringUtil mapToStringUtil, MapParser mapParser) {
            return new JdbcGameSavesRepository(connection, mapToStringUtil, mapParser);
        }

        */

        @Bean
        GameSavesRepository xmlGameSavesRepository(Marshaller marshaller, Unmarshaller unmarshaller) {
            return new XmlGameSavesRepository(marshaller, unmarshaller);
        }

}
