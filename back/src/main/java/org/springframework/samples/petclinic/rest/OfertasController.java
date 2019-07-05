
package org.springframework.samples.petclinic.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Ofertas;
import org.springframework.samples.petclinic.service.OfertasService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class OfertasController {
	@Autowired
	private OfertasService vc_ofertasService;



	@RequestMapping(value = "/ofertas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Ofertas>> getListaOfertas(){

		return new ResponseEntity<List<Ofertas>>(vc_ofertasService.findAll(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/ofertas/{idOferta}", method=RequestMethod.GET)
	public ResponseEntity<Ofertas> findById(@PathVariable("id_oferta") Integer id){
		Ofertas oferta = new Ofertas();
		oferta = this.vc_ofertasService.findById(id);
		if(oferta !=null)
			return ResponseEntity.status(HttpStatus.OK).body(oferta);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	
	@RequestMapping(value = "/ofertas/activas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Ofertas>> getListaOfertasActivas(){

		return new ResponseEntity<List<Ofertas>>(vc_ofertasService.getListaOfertasActivas(), HttpStatus.ACCEPTED);
	}

	
	


	@RequestMapping(value = "/ofertas", method = RequestMethod.POST)
    public ResponseEntity<List<Ofertas>> processCreationForm(@Valid Ofertas ofertas, BindingResult result) {
        
    	if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        } else {
            this.vc_ofertasService.save(ofertas);
            return this.getListaOfertas();
        }
    }
	    
	
	
	
	@RequestMapping(value = "/ofertas/{id_ofertas}", method = RequestMethod.DELETE)
	public ResponseEntity<Ofertas> deleteUser(  @PathVariable("id_ofertas") int ofertaId) {
		System.out.println("Buscando y borrando la oferta con id " + ofertaId);
		Ofertas oferta =vc_ofertasService.findById(ofertaId);
		if (oferta == null) {
			System.out.println("No se puede borrar. Oferta con id " + ofertaId + " no encontrada.");
			return new ResponseEntity<Ofertas>(HttpStatus.NOT_FOUND);
		}

		vc_ofertasService.delete(oferta);
		return new ResponseEntity<Ofertas>(oferta, HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value="/ofertas/{idOferta}", method = RequestMethod.PUT)
	public Ofertas update(@PathVariable("idOferta") Integer id, @RequestBody Ofertas oferta) {
		Ofertas conecta = this.vc_ofertasService.findById(id);
		if(conecta != null) {
			oferta.setId(conecta.getId());
			return this.vc_ofertasService.save(oferta);
		}
		return null;

	}

}
