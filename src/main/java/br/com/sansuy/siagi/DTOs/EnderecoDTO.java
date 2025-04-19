package br.com.sansuy.siagi.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoDTO {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}
