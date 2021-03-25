package com.github.jonasxpx.provas.controller;

import com.github.jonasxpx.provas.model.Marca;
import com.github.jonasxpx.provas.service.MarcaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("marca")
public class MarcaController extends DefaultController<Marca, MarcaService> {
}
