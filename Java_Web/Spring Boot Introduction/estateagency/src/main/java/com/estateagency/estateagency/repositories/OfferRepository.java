package com.estateagency.estateagency.repositories;

import com.estateagency.estateagency.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer,Long> {
}
