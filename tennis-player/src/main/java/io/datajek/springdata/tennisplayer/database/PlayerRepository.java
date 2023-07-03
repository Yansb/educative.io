package io.datajek.springdata.tennisplayer.database;

import io.datajek.springdata.tennisplayer.models.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PlayerRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Player insertPlayer (Player player) {
        return entityManager.merge(player);
    }

    public Player updatePlayer (Player player) {
        return entityManager.merge(player);
    }

    public Player findPlayerById (int id) {
        return entityManager.find(Player.class, id);
    }

    public void deleteById(int id){
        Player player = findPlayerById(id);
        entityManager.remove(player);
    }

    public List<Player> getAllPlayers() {
        final var getAll = entityManager.createNamedQuery("get_all_players", Player.class);

        return getAll.getResultList();
    }
}
