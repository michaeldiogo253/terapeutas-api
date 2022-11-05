package br.com.michael.practicing.criteria.api.personas.terapeuta.repository;

import br.com.michael.practicing.criteria.api.personas.terapeuta.domain.Terapeuta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerapeutaRepository extends JpaRepository<Terapeuta, Long> {

}
