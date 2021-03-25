package com.github.jonasxpx.provas.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

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

    @OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Veiculo> veiculos;
}
