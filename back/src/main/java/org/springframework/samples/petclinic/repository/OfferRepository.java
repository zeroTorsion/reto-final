package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Offer;

import java.util.List;

public interface OfferRepository {

    void save(Offer offer) throws DataAccessException;
    List<Offer> findByOfferId(Integer offerId);
    Offer findById(int id) throws DataAccessException;
    List<Offer> findAll() throws DataAccessException;
    void delete(Offer offer) throws DataAccessException;
}
