package br.com.eduardo.lojaveiculos;

import br.com.eduardo.lojaveiculos.dominio.Veiculo;
import br.com.eduardo.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;

public class BuscandoVeiculo3 {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();

        Veiculo veiculo = manager.getReference(Veiculo.class, 1L);
        System.out.println("Buscando o veiculo. Será que executou o SELECT?");
        System.out.println("Veiculo de codigo: " + veiculo.getCodigo() + " é um " + veiculo.getModelo());

        manager.close();
        JpaUtil.close();
    }
}
