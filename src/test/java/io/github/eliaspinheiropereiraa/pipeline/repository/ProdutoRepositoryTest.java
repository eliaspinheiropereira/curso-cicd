package io.github.eliaspinheiropereiraa.pipeline.repository;

import io.github.eliaspinheiropereiraa.pipeline.model.Produto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    @DisplayName("cadastrar produto")
    void testSalvarProduto(){
        Produto produto = new Produto();
        produto.setNome("playstation 5");
        produto.setDescricao("video game da sony");
        produto.setQuantidade(1);
        produto.setValorTotal(new BigDecimal(3500));

        this.produtoRepository.save(produto);

        assertThat(produto).isNotNull();
        assertThat(produto.getNome()).isEqualTo("playstation 5");
    }

}