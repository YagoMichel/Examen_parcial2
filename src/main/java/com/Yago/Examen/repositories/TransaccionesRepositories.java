package com.Yago.Examen.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Yago.Examen.model.TransaccionesModel;


    @Repository
public interface TransaccionesRepositories {
    List<TransaccionesModel> findAll();
    TransaccionesModel findById(int id);
    void save(TransaccionesModel transaccion);
    void update(TransaccionesModel transaccion);
    void delete(int id);
}

