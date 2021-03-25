package com.github.jonasxpx.provas;

import com.github.jonasxpx.provas.model.Marca;
import com.github.jonasxpx.provas.model.Modelo;
import com.github.jonasxpx.provas.model.Veiculo;
import com.github.jonasxpx.provas.service.MarcaService;
import com.github.jonasxpx.provas.service.ModeloService;
import com.github.jonasxpx.provas.service.VeiculoService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class GerenciamentoDeVeiculosApplicationTests {

    @Autowired
    ModeloService modeloService;

    @Autowired
    MarcaService marcaService;

    @Autowired
    VeiculoService veiculoService;

    Veiculo c180;

    Modelo modelo;

    Marca marca;

    @BeforeEach
    void setUp() {
        marca = marcaService.persist(Marca.builder()
                .descricao("teste")
                .nome("Mercedes")
                .build());

        modelo = modeloService.persist(Modelo.builder()
                .marca(marca)
                .nome("Classe C")
                .build());

        Modelo modelo2 = modeloService.persist(Modelo.builder()
                .marca(marca)
                .nome("Classe A")
                .build());

        c180 = veiculoService.persist(Veiculo.builder()
                .nome("c180")
                .placa("000-0000")
                .modelo(modelo)
                .marca(marca)
                .build());
    }

    @AfterEach
    void setDown() {
        marcaService.getRepository().deleteAll();
        modeloService.getRepository().deleteAll();
        veiculoService.getRepository().deleteAll();
    }

    @Test
    public void shouldFindVeiculoByPlaca() {
        Veiculo veiculo = Assertions.assertDoesNotThrow(() -> veiculoService.findVeiculoByPlaca("000-0000"));
        assertEquals("000-0000", veiculo.getPlaca());
        assertEquals("c180", veiculo.getNome());
    }

    @Test
    public void shouldFindModelosPorMarca() {
        List<Modelo> modelos = Assertions.assertDoesNotThrow(() -> modeloService.findModeloByMarca(marca));
        assertEquals(2, modelos.size());
    }

    @Test
    public void shouldFindVeiculoPorMarca() {
        List<Veiculo> veiculos = Assertions.assertDoesNotThrow(() -> veiculoService.findVeiculosByMarca(marca));
        assertEquals(1, veiculos.size());
    }

    @Test
    public void shouldFindVeiculoPorModelo() {
        List<Veiculo> veiculos = Assertions.assertDoesNotThrow(() -> veiculoService.findVeiculosByModelo(modelo));
        assertEquals(1, veiculos.size());
    }

}
