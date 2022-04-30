package br.com.eduardo.lojaveiculos.dominio;

import br.com.eduardo.lojaveiculos.dominio.enums.TipoCombustivel;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tab_veiculo")
public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private VeiculoId codigo;

    @OneToOne(optional = true)
    @JoinColumn(name = "cod_proprietario")
    private Proprietario proprietario;

    @Column(length = 60, nullable = false)
    private String fabricante;
    @Column(length = 60, nullable = false)
    private String modelo;
    @Column(name = "ano_fabricante", nullable = false)
    private Integer anoFabricante;
    @Column(name = "ano_modelo", nullable = false)
    private Integer anoModelo;
    @Column(precision = 10, scale = 2, nullable = true)
    private BigDecimal valor;
    @Column(name = "tipo_combustivel", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    public Veiculo() {
    }

    public Veiculo(VeiculoId codigo, Proprietario proprietario, String fabricante, String modelo, Integer anoFabricante, Integer anoModelo, BigDecimal valor, TipoCombustivel tipoCombustivel, LocalDate dataCadastro) {
        this.codigo = codigo;
        this.proprietario = proprietario;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.anoFabricante = anoFabricante;
        this.anoModelo = anoModelo;
        this.valor = valor;
        this.tipoCombustivel = tipoCombustivel;
        this.dataCadastro = dataCadastro;
    }

    public VeiculoId getCodigo() {
        return codigo;
    }

    public void setCodigo(VeiculoId codigo) {
        this.codigo = codigo;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricante() {
        return anoFabricante;
    }

    public void setAnoFabricante(Integer anoFabricante) {
        this.anoFabricante = anoFabricante;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return codigo.equals(veiculo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
