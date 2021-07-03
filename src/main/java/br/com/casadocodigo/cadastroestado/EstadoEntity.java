package br.com.casadocodigo.cadastroestado;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "estado")
public class EstadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "estado", nullable = false)
    private String estado;

    @NotNull
    @Column(name = "id_pais", nullable = false)
    private Long idPais;


    public EstadoEntity() {
    }

    public EstadoEntity(@NotBlank String estado, @NotNull Long idPais) {
        this.estado = estado;
        this.idPais = idPais;
    }


    @Override
    public String toString() {
        return "Novo Estado: " +
                "\nId: " + id +
                "\nEstado: " + estado +
                "\nId Pais: " + idPais;
    }

}

