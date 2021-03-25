package com.github.jonasxpx.provas.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String placa;

    @JoinColumn(name = "id_marca")
    @ManyToOne
    private Marca marca;

    @JoinColumn(name = "id_modelo")
    @ManyToOne
    private Modelo modelo;


    @JsonGetter("marca")
    private Marca jsonMarca() {
        return Objects.nonNull(marca) ?
                Marca.builder()
                        .id(marca.getId())
                        .nome(marca.getNome())
                        .build() : null;
    }

    @JsonGetter("modelo")
    private Modelo jsonModelo() {
        return Objects.nonNull(modelo) ?
                Modelo.builder()
                        .id(modelo.getId())
                        .nome(modelo.getNome())
                        .build() : null;
    }
}
