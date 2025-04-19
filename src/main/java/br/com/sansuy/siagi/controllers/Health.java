package br.com.sansuy.siagi.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/health")
@Tag(name = "Health", description = "Testar saúde da API")
public class Health {
	@GetMapping
	public ResponseEntity<Object> getHealth(){
		
		LocalDateTime date = LocalDateTime.now();
		Map<String, String> response = new HashMap<>();
		
		response.put("status", "UP");
		response.put("timestamp", date.toString());
		
		return ResponseEntity.ok(response);
	}
}
