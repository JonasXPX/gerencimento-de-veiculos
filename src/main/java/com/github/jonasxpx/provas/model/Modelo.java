package com.github.jonasxpx.provas.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @JoinColumn(name = "id_marca")
    @ManyToOne
    private Marca marca;

    @JsonGetter("marca")
    private Marca jsonMarca() {
        return Objects.nonNull(marca) ?
                Marca.builder().id(marca.getId()).build() : null;
    }
}
