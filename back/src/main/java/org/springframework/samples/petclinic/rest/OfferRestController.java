package org.springframework.samples.petclinic.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Offer;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.OfferService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/api/")
public class OfferRestController {

	@Autowired
	private OfferService srv;

	@GetMapping("offers")
	public List<Offer> getOffers(){
		return srv.getOffers();
	}


	@GetMapping("offers/{id}")
	public ResponseEntity<Offer> getOfferById(@PathVariable("id") Integer id) {
		Offer offer = new Offer();
		offer = srv.getOfferById(id);
		if(offer != null) {
			return ResponseEntity.status(HttpStatus.OK).body(offer);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PreAuthorize( "hasRole(@roles.OWNER_ADMIN)" )
	@RequestMapping(value = "offers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Offer> addOffer(@RequestBody @Valid Offer offer, BindingResult bindingResult,
			UriComponentsBuilder ucBuilder) {
		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();
		if (bindingResult.hasErrors() || (offer == null)) {
			errors.addAllErrors(bindingResult);
			headers.add("errors", errors.toJSON());
			return new ResponseEntity<Offer>(headers, HttpStatus.BAD_REQUEST);
		}
		this.srv.addOffer(offer);
		headers.setLocation(ucBuilder.path("/api/offers/{id}").buildAndExpand(offer.getId()).toUri());
		return new ResponseEntity<Offer>(offer, headers, HttpStatus.CREATED);
	}

//	@PreAuthorize( "hasRole(@roles.OWNER_ADMIN)" )
//	@RequestMapping(value = "offers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ResponseEntity<Offer>addOffer(@RequestBody Offer offer) {
//		if (offer != null) {
//			if(offer.getId() != 0) {
//				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
//			} else {
//				return ResponseEntity.status(HttpStatus.OK).body(this.srv.addOffer(offer));
//			}
//		}
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//	}

	@PutMapping("offers/{id}")
	public ResponseEntity<Offer>updateAlumno(@PathVariable Integer id, @RequestBody Offer offer) {
		Offer newOoffer = srv.getOfferById(id);
		if (offer != null) {
			offer.setId(id);
			return ResponseEntity.status(HttpStatus.OK).body(this.srv.addOffer(offer));
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		}
	}

	@DeleteMapping("offers/{id}")
	public ResponseEntity<Offer> borrarPorId(@PathVariable Integer id) {
		System.out.print(id);
		Offer offer = srv.getOfferById(id);
		if (offer != null) {
			this.srv.deleteOfferById(id);
			return ResponseEntity.status(HttpStatus.OK).body(offer);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
}
