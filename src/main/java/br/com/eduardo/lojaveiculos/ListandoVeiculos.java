package br.com.eduardo.lojaveiculos;

import br.com.eduardo.lojaveiculos.dominio.Veiculo;
import br.com.eduardo.lojaveiculos.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ListandoVeiculos {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();

        Query query = manager.createQuery("select v from Veiculo v");
        List<Veiculo> veiculos = query.getResultList();

        for (Veiculo veiculo: veiculos) {
            System.out.println(veiculo.getCodigo() + " - "

            + veiculo.getFabricante()+ " - "
            + veiculo.getModelo() + ", ano "
            + veiculo.getAnoFabricante() + "/"
            + veiculo.getAnoModelo() + " por "
            + veiculo.getValor());
        }

        manager.close();
        JpaUtil.close();
    }
}
