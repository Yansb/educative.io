package io.datajek.springdata.tennisplayer;

import io.datajek.springdata.tennisplayer.database.PlayerRepository;
import io.datajek.springdata.tennisplayer.models.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.time.Instant;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(TennisPlayerApplication.class, args);
    }

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
                new Player("Djokovic", "Serbia", Instant.now(), 81)));

        logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
                new Player("Monfils", "France", Instant.now(), 10)));
        logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
                new Player("Other", "Austria",
                        Instant.now(), 17)));
        logger.info("\n\n>> Player with id 2: {}\n", playerRepository.findPlayerById(2));

        logger.info("\n\n>> Updating Player with Id 3: {}\n", playerRepository.updatePlayer(
                new Player(3, "Thiem", "Austria", Instant.now(), 17)));
        logger.info("All Players Data: {}", playerRepository.getAllPlayers());

        playerRepository.deleteById(3);
        logger.info("\n\n>> Player with id 3 \n");
    }
}
