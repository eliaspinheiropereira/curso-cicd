package io.github.eliaspinheiropereiraa.pipeline.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.eliaspinheiropereiraa.pipeline.dto.request.ProdutoRequest;
import io.github.eliaspinheiropereiraa.pipeline.service.ProdutoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProdutoController.class)
class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProdutoService produtoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("deve cadastrar produto e retornar 201 CREATED")
    void testCadastrarProdutoRetorna201() throws Exception {
        // Given
        ProdutoRequest dto = new ProdutoRequest(
                "teclado",
                "teclado mecanico",
                2,
                new BigDecimal("100")
        );

        doNothing().when(produtoService).cadastrarProduto(any(ProdutoRequest.class));

        String json = objectMapper.writeValueAsString(dto);

        // When & Then
        mockMvc.perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());

        verify(produtoService).cadastrarProduto(any(ProdutoRequest.class));
    }
}