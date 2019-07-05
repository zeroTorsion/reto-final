package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Ofertas;
import org.springframework.samples.petclinic.repository.OfertasRepository;
import org.springframework.stereotype.Service;

@Service
public class OfertasService  {
	@Autowired
	OfertasRepository vc_ofertasRepository;
	
	
	
	public List<Ofertas> findAll(){
		return this.vc_ofertasRepository.findAll();
	}
	
	public Ofertas findById(Integer id) {
		return this.vc_ofertasRepository.findOne(id);
	}
	
	public Ofertas save(Ofertas oferta) {
		 return this.vc_ofertasRepository.save(oferta);
	}

	public Ofertas delete(Ofertas oferta) {
		this.vc_ofertasRepository.delete(oferta);
		return oferta;
	}

	public void  deleteAll(){
		this.vc_ofertasRepository.deleteAll();
	}

	public Ofertas update(Ofertas oferta) {
		return this.vc_ofertasRepository.save(oferta);
	}

	public List<Ofertas> getListaOfertasActivas(){
		return this.vc_ofertasRepository.getListaOfertasActivas();
	}
	
}
