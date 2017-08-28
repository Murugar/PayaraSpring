package com.spring.payara.persistence.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.payara.persistence.entity.Sample;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class MyRepository {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public List<Sample> findAll() {
        return jdbcTemplate.query("SELECT id, name FROM sample ORDER BY id", (rs, rowNum) -> {
            return new Sample(rs.getInt("id"), rs.getString("name"));
        });
    }

    @Transactional
    public void insert(Sample sample) {
        jdbcTemplate.update("INSERT INTO sample(id, name) VALUES(?, ?)", sample.getId(), sample.getName());
    }
}
