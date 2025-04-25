package br.com.spring.fabrica.mappers;

import br.com.spring.fabrica.DTOs.ProdutoDTO;
import br.com.spring.fabrica.models.Fabrica;
import br.com.spring.fabrica.models.Produto;

public class ProdutoMapper {
	public static Produto mapearDTOparaModel(ProdutoDTO produtoDTO, Fabrica fabrica) {
		return Produto.builder()
				.nome(produtoDTO.getNome())
				.precoCusto(produtoDTO.getPrecoCusto())
				.fabrica(fabrica)
				.build();
	}
}
