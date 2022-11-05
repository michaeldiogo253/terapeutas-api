package br.com.michael.practicing.criteria.api.personas.terapeuta.service;

import br.com.michael.practicing.criteria.api.personas.terapeuta.domain.DadosPessoais;
import br.com.michael.practicing.criteria.api.personas.terapeuta.domain.Terapeuta;
import br.com.michael.practicing.criteria.api.personas.terapeuta.domain.Usuario;
import br.com.michael.practicing.criteria.api.personas.terapeuta.repository.TerapeutaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class PopulaBancoDeDadosService {

	private final TerapeutaRepository terapeutaRepository;

	public void persisteDados() {

		Usuario usuarioMichael = new Usuario("michael", "123456");
		DadosPessoais dadosPessoaisMichael = new DadosPessoais("Michael Diogo Fagundes",
		                                                       "12378963214",
		                                                       "michaeldiogo@outlook.com",
		                                                       LocalDate.of(1995, 1, 10),
		                                                       usuarioMichael);

		Terapeuta terapeutaMichael = new Terapeuta(dadosPessoaisMichael, "17", "Psicologia");

		Usuario usuarioCaio = new Usuario("caio", "1234");
		DadosPessoais dadosPessoaisCaio = new DadosPessoais("Caio Silva",
		                                                    "12378963555",
		                                                    "caio@outlook.com",
		                                                    LocalDate.of(1992, 5, 14),
		                                                    usuarioCaio);
		Terapeuta terapeutaCaio = new Terapeuta(dadosPessoaisCaio, "15", "Cardiologia");

		Usuario usuarioRafael = new Usuario("rafael", "654321");
		DadosPessoais dadosPessoaisRafael = new DadosPessoais("Rafael Souza",
		                                                      "89778963634",
		                                                      "rafael@gmail.com",
		                                                      LocalDate.of(1999, 10, 20),
		                                                      usuarioRafael);
		Terapeuta terapeutaRafael = new Terapeuta(dadosPessoaisRafael, "10", "Oftalmologia");

		Usuario usuarioRodrigo = new Usuario("rodrigo", "121212");
		DadosPessoais dadosPessoaisRodrigo = new DadosPessoais("Rodrigo Souza",
		                                                       "69778463638",
		                                                       "rodrigo@gmail.com",
		                                                       LocalDate.of(1998, 10, 11),
		                                                       usuarioRodrigo);
		Terapeuta terapeutaRodrigo = new Terapeuta(dadosPessoaisRodrigo, "11", "Oftalmologia");

		Usuario usuarioKelly = new Usuario("kelly", "131313");
		DadosPessoais dadosPessoaisKelly = new DadosPessoais("Kelly Assis",
		                                                     "19793263638",
		                                                     "kellyassis@gmail.com",
		                                                     LocalDate.of(1998, 6, 29),
		                                                     usuarioKelly);
		Terapeuta terapeutaKelly = new Terapeuta(dadosPessoaisKelly, "13", "Cardiologia");

		Usuario usuarioJoao = new Usuario("joao", "554412");
		DadosPessoais dadosPessoaisJoao = new DadosPessoais("Joao Silva Assis",
		                                                    "29793267625",
		                                                    "joao@gmail.com",
		                                                    LocalDate.of(1991, 4, 19),
		                                                    usuarioJoao);
		Terapeuta terapeutaJoao = new Terapeuta(dadosPessoaisJoao, "18", "Dermatologia");

		List<Terapeuta> terapeutas = new ArrayList<>();
		terapeutas.add(terapeutaMichael);
		terapeutas.add(terapeutaCaio);
		terapeutas.add(terapeutaRafael);
		terapeutas.add(terapeutaRodrigo);
		terapeutas.add(terapeutaKelly);
		terapeutas.add(terapeutaJoao);
		terapeutaRepository.saveAll(terapeutas);
	}

}
