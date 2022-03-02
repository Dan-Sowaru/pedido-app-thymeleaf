package br.com.letscode.pedidoapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class RetornoPedidoDTO {
    private String produto;
    private BigDecimal valor;
    private LocalDate dataEntrega;
    private String descricao;

}
