package br.com.casadocodigo.novoautor;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String nome;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(max = 400)
    @Column(nullable = false, unique = true, length = 400)
    private String descricao;
    private LocalDateTime instanteCadastro = LocalDateTime.now();

    public AutorEntity() {
    }

    public AutorEntity(@NotBlank String nome,
                       @NotBlank @Email String email,
                       @NotBlank @Size(max = 400) String descricao) {
        Assert.hasLength(nome, "O nome é obrigatório");
        Assert.hasLength(email, "O e-mail é obrigatório");
        Assert.hasLength(descricao, "A descrição é obrigatória e deve ter no máximo 400 caracteres");
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Autor -> " +
                "\nId: " + id +
                ", \nNome: " + nome +
                ", \nEmail: " + email +
                ", \nDescricao: " + descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstanteCadastro() {
        return instanteCadastro;
    }
}

