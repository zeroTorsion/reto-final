package org.springframework.samples.petclinic.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.Offer;



public interface OfferRepository extends JpaRepository<Offer, Integer>{
	public Optional<Offer> findById(Integer id);
	public void deleteById(Integer id);
}
