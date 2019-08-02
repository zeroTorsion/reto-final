package org.springframework.samples.petclinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.samples.petclinic.model.Offer;
import org.springframework.samples.petclinic.repository.OfferRepository;
import org.springframework.stereotype.Service;


@Service
public class OfferServiceImpl implements OfferService {
	
	@Autowired
	private OfferRepository repo;

	@Override
	public List<Offer> getOffers() {
		return repo.findAll();
	}

	@Override
	public Offer getOfferById(Integer id) {
		Optional<Offer> offer = repo.findById(id);
		return offer.isPresent() ? offer.get() : null;
	}
	
	@Override
	public Offer addAlumno(Offer offer) {
		return repo.save(offer);
	}

	@Override
	public boolean deleteOfferById(Integer id) {

		try {
			repo.deleteById(id);
			return true;
		} catch (EmptyResultDataAccessException e) {
			System.out.println("No se ha encontrado el profesor para eliminar");
			return false;
		} 
	}



}
