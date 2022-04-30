package br.com.eduardo.lojaveiculos;

import br.com.eduardo.lojaveiculos.dominio.Proprietario;
import br.com.eduardo.lojaveiculos.dominio.Veiculo;
import br.com.eduardo.lojaveiculos.dominio.VeiculoId;
import br.com.eduardo.lojaveiculos.dominio.enums.TipoCombustivel;
import br.com.eduardo.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        tx.begin();

        Proprietario proprietario = new Proprietario();
        proprietario.setNome("Aloni da Silva Ribeiro");
        proprietario.setTelefone("11 991742674");

        manager.persist(proprietario);

        Veiculo veiculo = new Veiculo();
        veiculo.setCodigo(new VeiculoId("ABC-4621", "São Paulo"));
        veiculo.setFabricante("Tesla");
        veiculo.setModelo("Model S Super");
        veiculo.setAnoFabricante(2021);
        veiculo.setAnoModelo(2021);
        veiculo.setValor(new BigDecimal(71_500));
        veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
        veiculo.setDataCadastro(LocalDate.now());
        veiculo.setProprietario(proprietario);

        manager.persist(veiculo);
        tx.commit();
        manager.close();
        JpaUtil.close();
    }
}
