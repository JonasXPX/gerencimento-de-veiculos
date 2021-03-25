package com.github.jonasxpx.provas.repository;

import com.github.jonasxpx.provas.model.Marca;
import com.github.jonasxpx.provas.model.Modelo;
import com.github.jonasxpx.provas.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Veiculo findOneByPlaca(String placa);

    List<Veiculo> findVeiculosByMarca(Marca marca);

    List<Veiculo> findVeiculosByModelo(Modelo modelo);
}