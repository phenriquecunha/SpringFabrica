package br.com.spring.fabrica.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FabricaDTO {
	private String nome;
	private EnderecoDTO endereco;
}
