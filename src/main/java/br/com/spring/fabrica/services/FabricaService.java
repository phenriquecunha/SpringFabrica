package br.com.spring.fabrica.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.spring.fabrica.DTOs.FabricaDTO;
import br.com.spring.fabrica.DTOs.ProdutoDTO;
import br.com.spring.fabrica.mappers.FabricaMapper;
import br.com.spring.fabrica.mappers.ProdutoMapper;
import br.com.spring.fabrica.models.Fabrica;
import br.com.spring.fabrica.models.Produto;
import br.com.spring.fabrica.repositories.FabricaRepository;

@Service
public class FabricaService {
	
    private final FabricaRepository fabricaRepository;
    private final ProdutoService produtoService;

    public FabricaService(FabricaRepository fabricaRepository, ProdutoService produtoService) {
        this.fabricaRepository = fabricaRepository;
        this.produtoService = produtoService;
    }
	
	public Fabrica criarFabrica(FabricaDTO dto) {
		Fabrica fabricaModel = FabricaMapper.mapearDTOparaModel(dto);
		return this.fabricaRepository.save(fabricaModel);
	}
	
	public List<Fabrica> listarTodasFabricas(){
		return this.fabricaRepository.findAll();
	}
	
	public Fabrica listarFabricaPeloId(Long id) {
		Optional<Fabrica> retornoRepository = this.fabricaRepository.findById(id);
		if(!retornoRepository.isPresent()) {
			throw new NoSuchElementException("Fábrica não encontrada!");
		}
		
		return retornoRepository.get();
	}
	
	public void excluirFabrica(Long id) {
		this.fabricaRepository.deleteById(id);
	}
	
	public void adicionarProduto(Long fabricaID, ProdutoDTO produtoDTO) {
		Fabrica fabrica = this.listarFabricaPeloId(fabricaID);
		Produto produto = ProdutoMapper.mapearDTOparaModel(produtoDTO, fabrica);
		this.produtoService.salvarProduto(produto);
	}
}
