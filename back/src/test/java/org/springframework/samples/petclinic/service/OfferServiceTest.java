package org.springframework.samples.petclinic.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Offer;

public class OfferServiceTest {
	@Autowired
	private OfferService service;
	private Offer offer;
	
	@Before
	public void setUp() {
		offer = new Offer();
		offer.setTitle("Titulo de prueba");
		offer.setDiscount(10d);
		offer.setDescription("Descripción de prueba");
	}
	
	@Test
	public void addOfferTest() {
		assertNotNull(service.addOffer(offer));
	}
	
	@Test
	public void deleteOfferByIdTest() {
		Offer o = service.getOfferById(3);
		assertNotNull(o);
		service.deleteOfferById(3);
		o = service.getOfferById(3);
		assertNull(o);
	}
	
	@Test
	public void getOffersTest() {
		assertNotNull(service.getOffers());
	}
	
	@Test
	public void getOfferById() {
		assertNotNull(service.getOfferById(1));
	}

}
