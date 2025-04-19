package br.com.sansuy.siagi.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sansuy.siagi.models.Endereco;
import br.com.sansuy.siagi.models.Produto;
import br.com.sansuy.siagi.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/produto")
@Tag(name = "Rotas Produto")
public class ProdutoController {
	
	private static final Logger logger = LoggerFactory.getLogger(Endereco.class);
	private final ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping
	@Operation(summary = "Listar todos os produtos")
	public ResponseEntity<Object> listarFabricas(){
		try {			
			List<Produto> listaProduto = this.produtoService.listarTodosProdutos();
			return ResponseEntity.ok(listaProduto);
		}catch (Exception e) {
			logger.error("listarFabricas() :: Erro ao listar produtos", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar produtos");
		}
		
	}
	
	@GetMapping("/:id")
	@Operation(summary = "Listar produto por ID")
	public ResponseEntity<Object> listarProdutoPorId(@PathParam(value = "id") Long id){
		try {			
			Produto produto = this.produtoService.listarProdutoPorId(id);
			return ResponseEntity.ok(produto);
		}catch (Exception e) {
			logger.error("listarFabricas() :: Erro ao lista produto", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao lista produto");
		}
		
	}
	
	@DeleteMapping(":/id")
	@Operation(summary = "Excluir produto por ID",responses = {
	        @ApiResponse(responseCode = "204", description = "Produto excluído com sucesso"),
	        @ApiResponse(responseCode = "500", description = "Erro interno ao excluir o produto")
	})
	public ResponseEntity<Object> excluirProdutoPorId(@PathParam(value = "id") Long id){
		try {			
			this.produtoService.excluirProdutoPorId(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (Exception e) {
			logger.error("listarFabricas() :: Erro ao excluir produto", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir produto");
		}
		
	}
	
}

