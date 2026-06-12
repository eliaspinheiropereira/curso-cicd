package io.github.eliaspinheiropereiraa.pipeline.controller;

import io.github.eliaspinheiropereiraa.pipeline.dto.request.ProdutoRequest;
import io.github.eliaspinheiropereiraa.pipeline.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
@Slf4j
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Void> cadastrarProduto(
            @RequestBody ProdutoRequest dto
    ) {
        log.info("POST -> /produtos {}",dto);
        this.produtoService.cadastrarProduto(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
