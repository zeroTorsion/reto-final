
package org.springframework.samples.petclinic.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Ofertas;
import org.springframework.samples.petclinic.repository.OfertasRepository;
import org.springframework.samples.petclinic.service.OfertasService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class OfertasController {
	@Autowired
	private OfertasService vc_ofertasService;
	private static final String VIEWS_OFERTAS_CREATE_OR_UPDATE_FORM = "ofertas/createOrUpdateOfertasForm";
	private  OfertasRepository  ofertas;


	@RequestMapping(value = "/ofertas", method = RequestMethod.GET)
	public ResponseEntity<List<Ofertas>> getListaOfertas(){

		return new ResponseEntity<List<Ofertas>>(vc_ofertasService.findAll(), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/api/ofertas", method = RequestMethod.POST)
    public String processUpdateOwnerForm(@Valid Ofertas oferta, BindingResult result, @PathVariable("id_ofertas") int ofertaId) {
        if (result.hasErrors()) {
            return VIEWS_OFERTAS_CREATE_OR_UPDATE_FORM;
        } else {
            oferta.setId(ofertaId);
            this.ofertas.save(oferta);
            return "redirect:/ofertas/{ofertaId}";
        }
    }

}
