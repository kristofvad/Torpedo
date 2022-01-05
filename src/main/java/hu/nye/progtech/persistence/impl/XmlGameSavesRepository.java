package hu.nye.progtech.persistence.impl;

import java.io.File;

import hu.nye.progtech.game.Map;
import hu.nye.progtech.repo.GameSavesRepository;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * XML based implementation of {@link GameSavesRepository}.
 */
public class XmlGameSavesRepository implements GameSavesRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlGameSavesRepository.class);

    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;

    public XmlGameSavesRepository(Marshaller marshaller, Unmarshaller unmarshaller) {
        this.marshaller = marshaller;
        this.unmarshaller = unmarshaller;
    }


    @Override
    public void save(Map currentMap) {
        try {
            Map map = new Map(currentMap.getPlayerMap(), currentMap.getPlayer2Map(),
                    currentMap.getPlayerShips(), currentMap.getPlayer2Ships());
            marshaller.marshal(map, new File("state.xml"));
        } catch (JAXBException e) {
            LOGGER.error("Error during saving state to XML", e);
            throw new RuntimeException("Failed to save XML", e);
        }


    }


    @Override
    public Map load() {
        try {
            Map map = (Map) unmarshaller.unmarshal(new File("state.xml"));
            return new Map(map.getPlayerMap(), map.getPlayer2Map(), map.getPlayerShips(), map.getPlayer2Ships());
        } catch (JAXBException e) {
            LOGGER.error("Error during loading state to XML", e);
            throw new RuntimeException("Failed to load XML", e);
        }
    }


}
