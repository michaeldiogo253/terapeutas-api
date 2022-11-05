package br.com.michael.practicing.criteria.api.personas.terapeuta.service;

import br.com.michael.practicing.criteria.api.personas.terapeuta.domain.Terapeuta;
import br.com.michael.practicing.criteria.api.personas.terapeuta.repository.TerapeutaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTerapeutasService {

	private final TerapeutaRepository terapeutaRepository;
	private final EntityManager entityManager;

	public List<Terapeuta> execute( String nome){

		String jpql = "SELECT t FROM Terapeuta t " +
		              "JOIN DadosPessoais d on d = t.dadosPessoais " +
		              "JOIN Usuario u on u = d.usuario " +
		              "WHERE 1 = 1 ";

		if(nome != null && !nome.trim().isEmpty()){
			jpql += " AND lower(d.nomeCompleto) LIKE lower(CONCAT('%',:nome,'%')) ";
		}

		TypedQuery<Terapeuta> query = entityManager.createQuery(jpql, Terapeuta.class);

		if(nome != null && !nome.trim().isEmpty()){
			query.setParameter("nome", nome);
		}

		return query.getResultList();

	}

}
