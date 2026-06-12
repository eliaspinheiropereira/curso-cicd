package io.github.eliaspinheiropereiraa.pipeline.service;

import io.github.eliaspinheiropereiraa.pipeline.dto.request.ProdutoRequest;
import io.github.eliaspinheiropereiraa.pipeline.model.Produto;
import io.github.eliaspinheiropereiraa.pipeline.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public void cadastrarProduto(ProdutoRequest dto){
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setQuantidade(dto.quantidade());
        produto.setValorTotal(dto.valorTotal());

        this.produtoRepository.save(produto);
    }
}
