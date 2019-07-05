package org.springframework.samples.petclinic.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Ofertas;
import org.springframework.samples.petclinic.service.OfertasService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OfertasController {
	@Autowired
	private OfertasService vc_ofertasService;
	
	
	
	@RequestMapping(value = "/ofertas", method = RequestMethod.GET)
	public ResponseEntity<List<Ofertas>> getListaOfertas(){
		
		return new ResponseEntity<List<Ofertas>>(vc_ofertasService.findAll(), HttpStatus.ACCEPTED);
	}
}
