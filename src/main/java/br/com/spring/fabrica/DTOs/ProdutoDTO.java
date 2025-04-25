package br.com.spring.fabrica.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoDTO {
	private String nome;
	private Double precoCusto;
}
