package com.github.jonasxpx.provas.service;

import com.github.jonasxpx.provas.model.Marca;
import com.github.jonasxpx.provas.model.Modelo;
import com.github.jonasxpx.provas.model.Veiculo;
import com.github.jonasxpx.provas.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService extends DefaultService<Veiculo, VeiculoRepository> {

    public Veiculo findVeiculoByPlaca(String placa) {
        return getRepository().findOneByPlaca(placa);
    }

    public List<Veiculo> findVeiculosByMarca(Marca marca) {
        return getRepository().findVeiculosByMarca(marca);
    }

    public List<Veiculo> findVeiculosByModelo(Modelo modelo) {
        return getRepository().findVeiculosByModelo(modelo);
    }
}
