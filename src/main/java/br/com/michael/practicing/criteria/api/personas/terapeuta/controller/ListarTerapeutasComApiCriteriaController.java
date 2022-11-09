package br.com.michael.practicing.criteria.api.personas.terapeuta.controller;

import br.com.michael.practicing.criteria.api.personas.terapeuta.domain.Terapeuta;
import br.com.michael.practicing.criteria.api.personas.terapeuta.service.ListarTerapeutasComApiCriteriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListarTerapeutasComApiCriteriaController {

	private final ListarTerapeutasComApiCriteriaService listarTerapeutasService;

	@GetMapping("/listar-terapeutas-api-criteria")
	public ResponseEntity<List<Terapeuta>> listarTerapeutas(@RequestParam(required = false) String especializacao) {

		List<Terapeuta> terapeutas = listarTerapeutasService.execute(especializacao);

		return ResponseEntity.ok(terapeutas);

	}

}
