package br.com.eduardo.lojaveiculos;

import br.com.eduardo.lojaveiculos.dominio.Veiculo;
import br.com.eduardo.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;

public class AtualizandoVeiculos {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        Veiculo veiculo = manager.find(Veiculo.class, 1L);
        System.out.println("Valor atual: " + veiculo.getValor());
        veiculo.setValor(veiculo.getValor().add(new BigDecimal(500)));
        System.out.println("Valor atualizado: " + veiculo.getValor());

        tx.commit();
        manager.close();
        JpaUtil.close();
    }
}
