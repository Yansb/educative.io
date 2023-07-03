package io.datajek.springdata.tennisplayer.database;

import io.datajek.springdata.tennisplayer.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer> {
}
