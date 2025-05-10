package com.Yago.Examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.Yago.Examen.model.TransaccionesModel;
import com.Yago.Examen.repositories.TransaccionesRepositories;

@Service
public class TransaccionesServices implements TransaccionesRepositories {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TransaccionesModel> findAll() {
        return jdbcTemplate.query("SELECT * FROM transacciones",
                new BeanPropertyRowMapper<>(TransaccionesModel.class));
    }

    @Override
    public TransaccionesModel findById(int id) {
        return jdbcTemplate.query("SELECT * FROM transacciones WHERE id=?",
                new BeanPropertyRowMapper<>(TransaccionesModel.class), id)
                .stream().findFirst().orElse(new TransaccionesModel());
    }

    @Override
    public void save(TransaccionesModel transaccion) {
        jdbcTemplate.update(
            "INSERT INTO transacciones (cuenta, tipo, monto, fecha) VALUES (?, ?, ?, ?)",
            transaccion.getCuenta(),
            transaccion.getTipo(),
            transaccion.getMonto(),
            transaccion.getFecha()
        );
    }

    @Override
    public void update(TransaccionesModel transaccion) {
        jdbcTemplate.update(
            "UPDATE transacciones SET cuenta = ?, tipo = ?, monto = ?, fecha = ? WHERE id = ?",
            transaccion.getCuenta(),
            transaccion.getTipo(),
            transaccion.getMonto(),
            transaccion.getFecha(),
            transaccion.getId()
        );
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM transacciones WHERE id = ?", id);
    }
}
