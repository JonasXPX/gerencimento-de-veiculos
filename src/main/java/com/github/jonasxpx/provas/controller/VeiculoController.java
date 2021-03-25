package com.github.jonasxpx.provas.controller;

import com.github.jonasxpx.provas.model.Marca;
import com.github.jonasxpx.provas.model.Modelo;
import com.github.jonasxpx.provas.model.Veiculo;
import com.github.jonasxpx.provas.service.MarcaService;
import com.github.jonasxpx.provas.service.ModeloService;
import com.github.jonasxpx.provas.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "veiculo")
public class VeiculoController extends DefaultController<Veiculo, VeiculoService>{

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private ModeloService modeloService;

    @GetMapping("by-marca/{id}")
    public ResponseEntity<List<Veiculo>> findVeiculosByMarca(@PathVariable Long id) {
        Marca marca = marcaService.findById(id);
        return ResponseEntity.ok(getService().findVeiculosByMarca(marca));
    }

    @GetMapping("by-modelo/{id}")
    public ResponseEntity<List<Veiculo>> findVeiculosByModelo(@PathVariable Long id) {
        Modelo modelo = modeloService.findById(id);
        return ResponseEntity.ok(getService().findVeiculosByModelo(modelo));
    }
}
