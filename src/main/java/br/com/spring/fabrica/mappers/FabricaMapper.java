package br.com.spring.fabrica.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.spring.fabrica.DTOs.FabricaDTO;
import br.com.spring.fabrica.models.Endereco;
import br.com.spring.fabrica.models.Fabrica;

public class FabricaMapper {
	
	private static final Logger logger = LoggerFactory.getLogger(Endereco.class);
	
	public static Fabrica mapearDTOparaModel(FabricaDTO fabricaDto) {
		logger.info("mapearDTOparaModel :: criando model a partir do dto" + fabricaDto.toString());
		Endereco enderecoModel = EnderecoMapper.mapearDTOParaModel(fabricaDto.getEndereco());
		Fabrica fabricaModel = Fabrica.builder()
				.nome(fabricaDto.getNome())
				.endereco(enderecoModel)
				.build();
		
		return fabricaModel;
	}
}
