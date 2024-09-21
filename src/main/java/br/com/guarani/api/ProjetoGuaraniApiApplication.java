package br.com.guarani.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport // recurso da paginação
@EnableSwagger2// anotação do swagger
public class ProjetoGuaraniApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoGuaraniApiApplication.class, args);
	}

}
