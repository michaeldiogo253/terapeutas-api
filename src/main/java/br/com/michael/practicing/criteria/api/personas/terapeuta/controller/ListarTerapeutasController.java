package br.com.michael.practicing.criteria.api.personas.terapeuta.controller;

import br.com.michael.practicing.criteria.api.personas.terapeuta.domain.Terapeuta;
import br.com.michael.practicing.criteria.api.personas.terapeuta.service.ListarTerapeutasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListarTerapeutasController {

	private final ListarTerapeutasService listarTerapeutasService;

	@GetMapping("/listar-terapeutas")
	public ResponseEntity<List<Terapeuta>> listarTerapeutas(@RequestParam(required = false) String nome) {

		List<Terapeuta> terapeutas = listarTerapeutasService.execute(nome);

		return ResponseEntity.ok(terapeutas);

	}

}
