package br.com.spring.fabrica.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.fabrica.DTOs.FabricaDTO;
import br.com.spring.fabrica.DTOs.ProdutoDTO;
import br.com.spring.fabrica.models.Endereco;
import br.com.spring.fabrica.models.Fabrica;
import br.com.spring.fabrica.services.FabricaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/fabrica")
@Tag(name = "Rotas Fabrica")
public class FabricaController {
	
	private static final Logger logger = LoggerFactory.getLogger(Endereco.class);
	private final FabricaService fabricaService;
	
	public FabricaController(FabricaService fabricaService) {
		this.fabricaService = fabricaService;
	}
	
	@PostMapping
	@Operation(summary = "Criar fábrica")
	public ResponseEntity<Object> criarFabrica(@RequestBody FabricaDTO dto){

		try {			
			Fabrica fabrica = this.fabricaService.criarFabrica(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(fabrica);
		} catch (Exception e) {
			logger.error("criarFabrica() :: Erro ao criar fábrica", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar fábrica");
		}

	}
	
	@GetMapping
	@Operation(summary = "Listar todas as fábricas")
	public ResponseEntity<Object> listarFabricas(){
		try {			
			List<Fabrica> listaFabrica = this.fabricaService.listarTodasFabricas();
			return ResponseEntity.ok(listaFabrica);
		}catch (Exception e) {
			logger.error("listarFabricas() :: Erro ao listar fábricas", e.getCause());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar fábricas");
		}
		
	}
	
	@GetMapping("/:id")
	@Operation(summary = "Listar uma fábrica pelo ID")
	public ResponseEntity<Object> listarFabricaPorId(@PathParam(value = "id") Long id){
		try {			
			Fabrica fabrica = this.fabricaService.listarFabricaPeloId(id);
			return ResponseEntity.status(HttpStatus.CREATED).body(fabrica);
		} catch (NoSuchElementException e) {
			logger.error("listarFabricaPorId() :: Fabrica não encontrada", e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fábrica inexistente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar fábrica");
		}
	}
	
	@DeleteMapping(":/id")
	@Operation(summary = "Excluir uma fábrica pelo ID", responses = {
	        @ApiResponse(responseCode = "204", description = "Fábrica excluída com sucesso"),
	        @ApiResponse(responseCode = "500", description = "Erro interno ao excluir a fábrica")
	})
	public ResponseEntity<Object> excluirFabricaPorId(@PathParam(value = "id") Long id){
		try {			
			this.fabricaService.excluirFabrica(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			logger.error("excluirFabricaPorId() :: Erro ao excluir fábrica", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir fábrica");
		}
	}
	
	@PostMapping(":/id/produto")
	@Operation(summary = "Adicionar um produto a uma fábrica",  responses = {
	        @ApiResponse(responseCode = "201", description = "Produto adicionado com sucesso")
	})
	public ResponseEntity<Object> adicionarProduto(@PathParam(value = "id") Long fabricaID, @RequestBody ProdutoDTO dto){
		try {			
			this.fabricaService.adicionarProduto(fabricaID, dto);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			logger.error("adicionarProduto() :: Erro ao adicionar produto á fábrica", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar produto á fábrica");
		}
	}
}
