package com.estateagency.estateagency.repositories;

import com.estateagency.estateagency.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface OfferRepository extends JpaRepository<Offer,Long> {
   @Query("SELECT o FROM Offer o WHERE o.apartmentType = :types AND o.apartmentRent+(o.apartmentRent*(o.agencyCommission/100)) <= :budget")
    public List<Offer> findOffersThatMatchesBudget(@Param("types") String type,@Param("budget")BigDecimal budget);
}
