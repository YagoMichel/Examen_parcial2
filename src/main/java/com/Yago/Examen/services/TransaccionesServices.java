package com.Yago.Examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Yago.Examen.repositories.TransaccionesRepositories;

public class TransaccionesServices implements TransaccionesRepositories {


    @Autowired
    JdbcTemplate jdbcTemplate;


}
