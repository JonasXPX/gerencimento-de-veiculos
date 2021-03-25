package com.github.jonasxpx.provas.controller;

import com.github.jonasxpx.provas.model.Marca;
import com.github.jonasxpx.provas.model.Modelo;
import com.github.jonasxpx.provas.service.MarcaService;
import com.github.jonasxpx.provas.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("modelo")
public class ModeloController extends DefaultController<Modelo, ModeloService> {

    @Autowired
    private MarcaService marcaService;

    @GetMapping("by-marca/{id}")
    public ResponseEntity<List<Modelo>> findModeloByMarcaId(@PathVariable Long id) {
        Marca marca = marcaService.findById(id);
        return ResponseEntity.ok(getService().findModeloByMarca(marca));
    }
}
