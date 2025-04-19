package br.com.sansuy.siagi.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.sansuy.siagi.models.Produto;
import br.com.sansuy.siagi.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Produto salvarProduto(Produto produto) {
		return this.produtoRepository.save(produto);
	}

	public List<Produto> listarTodosProdutos() {
		
		return this.produtoRepository.findAll();
	}

	public Produto listarProdutoPorId(Long id) {
		Optional<Produto> retornoRepository = this.produtoRepository.findById(id);
		if(!retornoRepository.isPresent()) {
			throw new NoSuchElementException("Produto não encontrado!");
		}
		
		return retornoRepository.get();
	}

	public void excluirProdutoPorId(Long id) {
		
		this.produtoRepository.deleteById(id);
	}
}
