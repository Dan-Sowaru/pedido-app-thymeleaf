package br.com.letscode.pedidoapp.service;

import br.com.letscode.pedidoapp.dto.CadastrarPedidoDTO;
import br.com.letscode.pedidoapp.dto.RetornoPedidoDTO;
import br.com.letscode.pedidoapp.entity.PedidoEntidade;
import br.com.letscode.pedidoapp.repository.PedidoRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PedidoService {

    private PedidoRepository pedidoRepository;

    public void cadastrarPedido(CadastrarPedidoDTO cadastrarPedidoDTO) {

        pedidoRepository = new PedidoRepository();

        EnviarEmailService enviarEmailService = new EnviarEmailService();
        enviarEmailService.enviar(cadastrarPedidoDTO.getEmail());

        PedidoEntidade pedidoEntidade = new PedidoEntidade();
        pedidoEntidade.setProduto(cadastrarPedidoDTO.getProduto());
        pedidoEntidade.setDescricao(cadastrarPedidoDTO.getDescricao());
        pedidoEntidade.setValor(cadastrarPedidoDTO.getValor());

        LocalDate dataEntrega = calcularDataEntrega(cadastrarPedidoDTO.getEndereco());
        pedidoEntidade.setDataEntrega(dataEntrega);

        pedidoRepository.salvar(pedidoEntidade);
    }

    public List<RetornoPedidoDTO> listarTodosOsPedidos() {
        pedidoRepository = new PedidoRepository();
        List<PedidoEntidade> entidades = pedidoRepository.getAll();
        List<RetornoPedidoDTO> listaRetorno = entidades.stream()
                .map(entidade -> fromEntidadeToRetornoPedidoDTO(entidade))
                .collect(Collectors.toList());

        return listaRetorno;

    }

    private LocalDate calcularDataEntrega(String estado) {
        Map<String, Integer> frete = new HashMap<>();
        frete.put("SP", 12);
        frete.put("DF", 4);

        return LocalDate.now().plusDays(frete.get(estado));
    }

    private RetornoPedidoDTO fromEntidadeToRetornoPedidoDTO(PedidoEntidade pedidoEntidade) {
        RetornoPedidoDTO retornoPedidoDTO = new RetornoPedidoDTO();
        retornoPedidoDTO.setProduto(pedidoEntidade.getProduto());
        retornoPedidoDTO.setDescricao(pedidoEntidade.getDescricao());
        retornoPedidoDTO.setValor(pedidoEntidade.getValor());
        retornoPedidoDTO.setDataEntrega(pedidoEntidade.getDataEntrega());
        return retornoPedidoDTO;
    }
}
