package com.microservico.digihub.domain.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
@Table(name = "enderecos")
@AllArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //para gerar um id automaticamente
    @Column(name = "id")
    private UUID id;

    @Column(name = "endereco", nullable = false, length = 200)
    private String endereco;

    @Column(name = "estado", length = 2)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
