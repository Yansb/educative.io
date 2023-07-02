package io.datajek.springdata.tennisplayer;

import io.datajek.springdata.tennisplayer.database.PlayerRepository;
import io.datajek.springdata.tennisplayer.models.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {

    final
    PlayerRepository repository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public TennisPlayerApplication(PlayerRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TennisPlayerApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("Inserting Player 4 -> {}", repository.insertPlayer(
                new Player(4, "Roger Federer", "Switzerland", Instant.now(), 103)
        ));
        logger.info("All users -> {}", repository.getAllPlayers());
        final var player = repository.getPlayerById(1);

        logger.info("Updated Player 1 -> {}", repository.updatePlayer(
                new Player(player.getId(), player.getName(), "Spain", player.getBirthDate(),player.getTitles())
        ));
        logger.info("Update Player 1 -> {}", repository.getPlayerById(1));
        logger.info("Delete Player 2 -> {}", repository.deletePlayer(2));
        logger.info("All users -> {}", repository.getAllPlayers());
        repository.createTournamentTable();
        logger.info("Get player by nationality 'Spain' -> {}", repository.getPlayerByNationality("Spain"));
    }
}
