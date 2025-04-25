package br.com.spring.fabrica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.spring.fabrica.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{}
