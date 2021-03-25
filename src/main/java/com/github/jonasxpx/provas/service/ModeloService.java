package com.github.jonasxpx.provas.service;

import com.github.jonasxpx.provas.model.Marca;
import com.github.jonasxpx.provas.model.Modelo;
import com.github.jonasxpx.provas.repository.ModeloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService extends DefaultService<Modelo, ModeloRepository>{

    public List<Modelo> findModeloByMarca(Marca marca) {
        return getRepository().findModeloByMarca(marca);
    }
}
