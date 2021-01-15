package com.udacity.nd035.c3.EntityEx.ex2.service;

import com.udacity.nd035.c3.EntityEx.ex2.inventory.CandyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CandyDAOImpl implements CandyDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_CANDY = "SELECT * FROM candy";

    private static final String INSERT_CANDY_INTO_DELIVERY = "INSERT INTO candy_delivery (candy_id, delivery_id)" +
                                                                "VALUES(:candy_id, :delivery_id)";

    private static final String SELECT_CANDY_BY_DELIVERY = "SELECT * FROM candy_delivery cd" +
                                                            "JOIN candy c" +
                                                            "ON c.id = cd.candy_id" +
                                                            "WHERE cd.delivery_id = :deliveryId";

    @Override
    public List<CandyData> getListCandy () {
        return jdbcTemplate.query(SELECT_ALL_CANDY, new BeanPropertyRowMapper<>(CandyData.class));
    }

    @Override
    public void addCandyToDelivery (Long candyId, Long deliveryId) {
        jdbcTemplate.update(
                    INSERT_CANDY_INTO_DELIVERY,
                    new MapSqlParameterSource().addValue("candy_id", candyId)
                                                .addValue("delivery_id", deliveryId)
        );
    }

    @Override
    public List<CandyData> findCandyByDelivery (Long deliveryId) {
        return jdbcTemplate.query(SELECT_CANDY_BY_DELIVERY,
                                new MapSqlParameterSource().addValue("deliveryId", deliveryId),
                                new BeanPropertyRowMapper<>(CandyData.class));
    }
}
