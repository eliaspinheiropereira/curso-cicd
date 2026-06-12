package io.github.eliaspinheiropereiraa.pipeline.dto.request;

import java.math.BigDecimal;

public record ProdutoRequest (
    String nome,
    String descricao,
    int quantidade,
    BigDecimal valorTotal
){}

