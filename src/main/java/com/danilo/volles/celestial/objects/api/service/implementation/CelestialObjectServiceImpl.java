package com.danilo.volles.celestial.objects.api.service.implementation;

import com.danilo.volles.celestial.objects.api.persistence.document.CelestialObjectDocument;
import com.danilo.volles.celestial.objects.api.persistence.repository.CelestialObjectsRepository;
import com.danilo.volles.celestial.objects.api.service.CelestialObjectService;
import com.danilovolles.celestialobjects.CelestialObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CelestialObjectServiceImpl implements CelestialObjectService {

    private final CelestialObjectsRepository celestialObjectsRepository;

    public CelestialObjectServiceImpl(CelestialObjectsRepository celestialObjectsRepository) {
        this.celestialObjectsRepository = celestialObjectsRepository;
    }

    @Override
    public CelestialObjectDocument saveCelestialObject(CelestialObjectDocument celestialObject) {
        return celestialObjectsRepository.save(celestialObject);
    }

    @Override
    public CelestialObjectDocument getCelestialObject(String name) {
         return celestialObjectsRepository.findByName(name.trim());
    }

    @Override
    public List<CelestialObjectDocument> getAllCelestialObjects() {
        return celestialObjectsRepository.findAll();
    }
}
