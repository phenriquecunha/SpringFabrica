package br.com.sansuy.siagi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sansuy.siagi.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{}
