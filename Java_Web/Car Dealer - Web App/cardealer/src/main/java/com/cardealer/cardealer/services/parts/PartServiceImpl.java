package com.cardealer.cardealer.services.parts;

import com.cardealer.cardealer.entities.Parts;
import com.cardealer.cardealer.models.PartModel;
import com.cardealer.cardealer.repositories.PartsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartServiceImpl implements PartService {
    private final PartsRepository partsRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public PartServiceImpl(PartsRepository partsRepository, ModelMapper modelMapper) {
        this.partsRepository = partsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addPart(PartModel part) {
        this.partsRepository.save(modelMapper.map(part, Parts.class));
    }
}
