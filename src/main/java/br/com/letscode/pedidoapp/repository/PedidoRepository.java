package br.com.letscode.pedidoapp.repository;

import br.com.letscode.pedidoapp.entity.PedidoEntidade;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PedidoRepository {

    private static List<PedidoEntidade> pedidos = new ArrayList<>();

    static {
        pedidos.addAll(
                Arrays.asList(
                        new PedidoEntidade(1L,"Celular", BigDecimal.valueOf(799.0), LocalDate.now(), "iphone"),
                        new PedidoEntidade(2L,"Computador", BigDecimal.valueOf(1299.0), LocalDate.now(), "Positivo"),
                        new PedidoEntidade(3L,"Cadeira", BigDecimal.valueOf(1500), LocalDate.now(), "Razr")
                )
        );
    }

    public void salvar(PedidoEntidade entidade) {
        entidade.setId(pedidos.get(pedidos.size()-1).getId()+1);
        pedidos.add(entidade);
    }

    public List<PedidoEntidade> getAll() {
        return pedidos;
    }
}
