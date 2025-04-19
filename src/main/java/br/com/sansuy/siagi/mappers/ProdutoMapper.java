package br.com.sansuy.siagi.mappers;

import br.com.sansuy.siagi.DTOs.ProdutoDTO;
import br.com.sansuy.siagi.models.Fabrica;
import br.com.sansuy.siagi.models.Produto;

public class ProdutoMapper {
	public static Produto mapearDTOparaModel(ProdutoDTO produtoDTO, Fabrica fabrica) {
		return Produto.builder()
				.nome(produtoDTO.getNome())
				.precoCusto(produtoDTO.getPrecoCusto())
				.fabrica(fabrica)
				.build();
	}
}
