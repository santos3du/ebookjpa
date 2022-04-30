package br.com.eduardo.lojaveiculos.dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "proprietario")
public class Proprietario implements Serializable {
    public static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_proprietario", nullable = false)
    private String nome;

    @Column(name = "telefone_proprietario", nullable = false)
    private String telefone;

    @Column(name = "email_proprietario")
    private String email;

    public Proprietario(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Proprietario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
