package br.com.eduardo.lojaveiculos;

import br.com.eduardo.lojaveiculos.dominio.Veiculo;
import br.com.eduardo.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ExcluindoVeiculo {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        Veiculo veiculo = manager.find(Veiculo.class, 5L);
        manager.remove(veiculo);

        tx.commit();
        manager.close();
        JpaUtil.close();
    }
}
