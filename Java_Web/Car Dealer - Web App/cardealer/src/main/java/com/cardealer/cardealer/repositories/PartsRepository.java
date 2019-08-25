package com.cardealer.cardealer.repositories;

import com.cardealer.cardealer.entities.Parts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartsRepository extends JpaRepository<Parts,Long> {
}
