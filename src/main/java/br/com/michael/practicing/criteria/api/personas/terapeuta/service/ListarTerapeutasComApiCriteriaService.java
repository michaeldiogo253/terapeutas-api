package br.com.michael.practicing.criteria.api.personas.terapeuta.service;

import br.com.michael.practicing.criteria.api.personas.terapeuta.domain.Terapeuta;
import br.com.michael.practicing.criteria.api.personas.terapeuta.repository.TerapeutaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTerapeutasComApiCriteriaService {

	private final TerapeutaRepository terapeutaRepository;
	private final EntityManager entityManager;

	public List<Terapeuta> execute(
	                               String especializacao
	                               ) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Terapeuta> criteriaQuery = builder.createQuery(Terapeuta.class);
		Root<Terapeuta> from = criteriaQuery.from(Terapeuta.class);


		Predicate filtros = builder.and();


		if(especializacao != null && !especializacao.trim().isEmpty()){
			filtros =  builder.and(filtros, builder.like(from.get("especializacao"), "%"+especializacao+"%"));
		}

		criteriaQuery.where(filtros);

		return entityManager.createQuery(criteriaQuery).getResultList();
	}


}
