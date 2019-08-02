package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.samples.petclinic.model.Offer;


public interface OfferService {
	public List<Offer> getOffers();
	public Offer getOfferById(Integer id);
	public Offer addOffer(Offer alumno);
	public boolean deleteOfferById(Integer id);
}
