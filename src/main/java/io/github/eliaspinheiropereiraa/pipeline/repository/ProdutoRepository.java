package io.github.eliaspinheiropereiraa.pipeline.repository;

import io.github.eliaspinheiropereiraa.pipeline.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
