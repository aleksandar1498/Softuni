package com.cardealer.cardealer.services.parts;

import com.cardealer.cardealer.entities.Parts;
import com.cardealer.cardealer.repositories.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PartServiceImpl implements PartService {
    private final PartsRepository partsRepository;

    @Autowired
    public PartServiceImpl(PartsRepository partsRepository) {
        this.partsRepository = partsRepository;
    }

    @Override
    public void addPart(Parts part) {
        this.partsRepository.save(part);
    }
}
