package br.com.eduardo.lojaveiculos;

import br.com.eduardo.lojaveiculos.dominio.Veiculo;
import br.com.eduardo.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;

public class BuscandoVeiculo1 {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();

        Veiculo veiculo = manager.find(Veiculo.class, 1L);
        System.out.println("Veiculo de codigo: " + veiculo.getCodigo() + " é um " + veiculo.getModelo());

        manager.close();
        JpaUtil.close();
    }
}
