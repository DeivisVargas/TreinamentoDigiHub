package com.microservico.digihub.domain.entity;

import com.microservico.digihub.domain.entity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clientes")
@Builder
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome", nullable = false, unique = true, length = 100)
    private String nome;

    @Column(name = "documento", nullable = false, length = 200)
    private String documento;

    @Column(name = "razao_social", nullable = false, length = 200)
    private String razao_social;

    @Column(name = "representante", nullable = false, length = 200)
    private String representante;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 25)
    private Status status = Status.ATIVO;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Endereco> endereco;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(documento, cliente.documento) && Objects.equals(razao_social, cliente.razao_social) && Objects.equals(representante, cliente.representante) && status == cliente.status && Objects.equals(endereco, cliente.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, documento, razao_social, representante, status, endereco);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                '}';
    }
}
