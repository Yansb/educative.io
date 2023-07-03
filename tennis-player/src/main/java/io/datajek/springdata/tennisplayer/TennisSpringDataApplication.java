package io.datajek.springdata.tennisplayer;

import io.datajek.springdata.tennisplayer.database.PlayerRepository;
import io.datajek.springdata.tennisplayer.database.PlayerSpringDataRepository;
import io.datajek.springdata.tennisplayer.models.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.List;

@SpringBootApplication
public class TennisSpringDataApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(TennisSpringDataApplication.class, args);
    }

    @Autowired
    PlayerSpringDataRepository playerRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("\n\n>> Inserting Player: {}\n", playerRepository.saveAll(
                List.of(
                        new Player("Djokovic", "Serbia", Instant.now(), 81),
                        new Player("Monfils", "France", Instant.now(), 10),
                        new Player("Other", "Austria",Instant.now(), 17)
                )
        ));
        logger.info("\n\n>> Player with id 2: {}\n", playerRepository.findById(2));

        logger.info("\n\n>> Updating Player with Id 3: {}\n", playerRepository.save(
                new Player(3, "Thiem", "Austria", Instant.now(), 17)));
        logger.info("All Players Data: {}", playerRepository.findAll());

        playerRepository.deleteById(6);
        logger.info("\n\n>> Deleted Player with id 3 \n");
        logger.info("All Players Data: {}", playerRepository.findAll());
    }
}
