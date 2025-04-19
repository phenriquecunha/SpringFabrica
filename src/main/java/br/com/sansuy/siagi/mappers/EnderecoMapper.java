package br.com.sansuy.siagi.mappers;

import br.com.sansuy.siagi.DTOs.EnderecoDTO;
import br.com.sansuy.siagi.models.Endereco;

public class EnderecoMapper {
	public static Endereco mapearDTOParaModel(EnderecoDTO dto) {
		
		Endereco enderecoModel = Endereco.builder()
				.rua(dto.getRua())
				.numero(dto.getNumero())
				.bairro(dto.getBairro())
				.cidade(dto.getCidade())
				.estado(dto.getEstado())
				.cep(dto.getCep())
				.build();
		
		return enderecoModel;
	}
}
