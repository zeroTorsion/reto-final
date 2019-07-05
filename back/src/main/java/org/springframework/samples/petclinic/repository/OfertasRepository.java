package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.Ofertas;

public interface OfertasRepository extends JpaRepository<Ofertas, Integer>{
	@Query("Select o from ofertas o where vc_fexp>current_timestamp;")
	public List<Ofertas> getListaOfertasActivas();
}
