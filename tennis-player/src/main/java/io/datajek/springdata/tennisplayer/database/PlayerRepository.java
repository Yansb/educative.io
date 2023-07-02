package io.datajek.springdata.tennisplayer.database;

import io.datajek.springdata.tennisplayer.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Player> getAllPlayers(){
        final var sql = "SELECT * FROM player";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player>(Player.class));
    }

    public Player getPlayerById(int id){
        final var sql = "SELECT * FROM player WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(Player.class),
                new Object[] {id}
        );
    }

    public int insertPlayer(Player player){
        final var sql = "INSERT INTO player(id, name, nationality, birth_date, titles) " +
                        "VALUES(?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
                player.getId(),
                player.getName(),
                player.getNationality(),
                Timestamp.from(player.getBirthDate()),
                player.getTitles()
        );
    }

    public int updatePlayer(Player player){
        final var sql = "UPDATE PLAYER " +
                        "SET Name = ?, Nationality = ?, Birth_date = ?, Titles = ? " +
                        "WHERE ID = ?";
        return jdbcTemplate.update(sql,
                player.getName(),
                player.getNationality(),
                Timestamp.from(player.getBirthDate()),
                player.getTitles(),
                player.getId()
        );
    }

    public int deletePlayer(int id) {
        final var sql = "DELETE FROM player WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public void createTournamentTable(){
        String sql = "CREATE TABLE TOURNAMENT (ID INTEGER, NAME VARCHAR(50), LOCATION VARCHAR(50), PRIMARY KEY (ID))";
        jdbcTemplate.execute(sql);
        System.out.println("Table created");
    }

    public List<Player> getPlayerByNationality(String nationality) {
        String sql = "SELECT * FROM PLAYER WHERE NATIONALITY = ?";
        return jdbcTemplate.query(sql, new PlayerMapper(), new Object[] {nationality});
    }

    private static final class PlayerMapper implements RowMapper<Player> {
        @Override
        public Player mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Player player = new Player();
            player.setId(resultSet.getInt("id"));
            player.setName(resultSet.getString("name"));
            player.setNationality(resultSet.getString("nationality"));
            player.setBirthDate(resultSet.getTimestamp("birth_date").toInstant());
            player.setTitles(resultSet.getInt("titles"));
            return player;
        }
    }
}
