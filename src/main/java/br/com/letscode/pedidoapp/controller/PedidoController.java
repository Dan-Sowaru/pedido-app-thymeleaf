package br.com.letscode.pedidoapp.controller;


import br.com.letscode.pedidoapp.dto.CadastrarPedidoDTO;
import br.com.letscode.pedidoapp.dto.RetornoPedidoDTO;
import br.com.letscode.pedidoapp.entity.PedidoEntidade;
import br.com.letscode.pedidoapp.repository.PedidoRepository;
import br.com.letscode.pedidoapp.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @GetMapping("/listar")
    public String listar(Model model) {
        PedidoService pedidoService = new PedidoService();
        List<RetornoPedidoDTO> todosOsPedidosDTO = pedidoService.listarTodosOsPedidos();
        model.addAttribute("pedidos", todosOsPedidosDTO );
        return "listar-pedidos";
    }

    @GetMapping("/cadastrar-pedido-form")
    public String cadastrarPedidoForm(){
        return "cadastrar-pedido-form";
    }

    @PostMapping("/cadastrar-pedido")
    public RedirectView cadastrarPedido(CadastrarPedidoDTO cadastrarPedidoDTO) {
        PedidoService pedidoService = new PedidoService();
        pedidoService.cadastrarPedido(cadastrarPedidoDTO);
        RedirectView view = new RedirectView("/pedidos/listar", true);
        return view;
    }
}
