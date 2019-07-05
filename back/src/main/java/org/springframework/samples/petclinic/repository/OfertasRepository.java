package org.springframework.samples.petclinic.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Ofertas;
import org.springframework.stereotype.Component;
@Component
public interface OfertasRepository extends JpaRepository<Ofertas, Integer>{
	@Query("select o from Ofertas o where o.vcFexp>:fecha")
	public List<Ofertas> getListaOfertasActivas(@Param("fecha")Date today);
}
