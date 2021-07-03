package br.com.casadocodigo.cadastroestado;

import br.com.casadocodigo.cadastropais.PaisEntity;
import br.com.casadocodigo.validator.ExistsId;
import br.com.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CadastroEstadoDto {

    @NotBlank
    @JsonProperty("estado")
    @UniqueValue(domainClass = EstadoEntity.class, fieldName = "estado")
    private String estado;

    @NotNull
    @JsonProperty("id_pais")
    @ExistsId(domainClass = PaisEntity.class, fieldName = "id")
    private Long idPais;

    public CadastroEstadoDto() {
    }

    public CadastroEstadoDto(@NotBlank String estado,
                             @NotNull Long idPais) {
        this.estado = estado;
        this.idPais = idPais;
    }


    public EstadoEntity toModel(EntityManager manager) {
        return new EstadoEntity(this.estado, this.idPais);
    }


}
