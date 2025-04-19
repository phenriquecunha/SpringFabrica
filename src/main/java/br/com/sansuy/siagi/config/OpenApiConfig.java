package br.com.sansuy.siagi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
	info = @Info(title = "Minha API", version = "v1"),
	servers = {
	    @Server(url = "https://mildly-pure-squid.ngrok-free.app")
	}
)
public class OpenApiConfig {
}
