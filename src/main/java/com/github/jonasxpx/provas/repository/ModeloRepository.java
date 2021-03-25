package com.github.jonasxpx.provas.repository;

import com.github.jonasxpx.provas.model.Marca;
import com.github.jonasxpx.provas.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    List<Modelo> findModeloByMarca(Marca marca);
}
