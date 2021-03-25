package com.github.jonasxpx.provas.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.*;

import javax.persistence.*;

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


}
