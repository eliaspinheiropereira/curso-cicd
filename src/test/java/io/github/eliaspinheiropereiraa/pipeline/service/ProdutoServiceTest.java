package io.github.eliaspinheiropereiraa.pipeline.service;

import io.github.eliaspinheiropereiraa.pipeline.dto.request.ProdutoRequest;
import io.github.eliaspinheiropereiraa.pipeline.model.Produto;
import io.github.eliaspinheiropereiraa.pipeline.repository.ProdutoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @Test
    @DisplayName("deve cadastrar produto com sucesso")
    void testCadastrarProduto(){
        //given
        ProdutoRequest dto = new ProdutoRequest("teclado", "teclado mecanico", 2, new BigDecimal(100));
        Produto produto = new Produto();
        produto.setNome("teclado");
        produto.setDescricao("teclado mecanico");
        produto.setQuantidade(2);
        produto.setValorTotal(new BigDecimal(100));

        when(produtoRepository.save(any(Produto.class))).thenReturn(produto);

        //when
        this.produtoService.cadastrarProduto(dto);

        //then
        verify(produtoRepository).save(any(Produto.class));
    }

}