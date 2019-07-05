package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.repository.OfertasRepository;
import org.springframework.stereotype.Service;

@Service
public class OfertasService  {
	@Autowired
	OfertasRepository vc_ofertasRepository;

	

}
