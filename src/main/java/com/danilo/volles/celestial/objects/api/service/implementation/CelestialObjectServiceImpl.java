package com.danilo.volles.celestial.objects.api.service.implementation;

import com.danilo.volles.celestial.objects.api.persistence.document.CelestialObjectDocument;
import com.danilo.volles.celestial.objects.api.persistence.repository.CelestialObjectsRepository;
import com.danilo.volles.celestial.objects.api.service.CelestialObjectService;
import com.danilovolles.celestialobjects.CelestialObject;
import com.danilovolles.celestialobjects.CelestialObjectType;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public CelestialObjectDocument saveCelestialObject(CelestialObjectDocument celestialObjectDocument) {
        var name = celestialObjectDocument.getName();
        var celestialObject = celestialObjectsRepository.findByName(name);
        if (celestialObject != null) {
            throw new RuntimeException("Celestial object with name " + name + " already exists");
        }
        return celestialObjectsRepository.save(celestialObjectDocument);
    }

    @Override
    public CelestialObjectDocument getCelestialObjectByName(String name) {
        var celestialObjects = celestialObjectsRepository.findByName(name);
        if (celestialObjects.getName() == null) {
            throw new RuntimeException("No Celestial Object found with name " + name);
        }
        return celestialObjects;
    }

    @Override
    public List<CelestialObjectDocument> getAllCelestialObjects() {
        var celestialObjects = celestialObjectsRepository.findAll();
        if (celestialObjects.isEmpty()) {
            throw new RuntimeException("No Celestial Objects found");
        }
        return celestialObjects;
    }

    @Override
    public List<CelestialObjectDocument> getCelestialObjectsByType(String type) {
        CelestialObjectType objectType = CelestialObjectType.fromValue(type.trim().toUpperCase());
        var celestialObjects = celestialObjectsRepository.findAllByCelestialObjectType(objectType);
        if (celestialObjects.isEmpty()) {
            throw new RuntimeException("No Celestial Object found with type " + type);
        }
        return celestialObjects;
    }

    @Override
    public CelestialObjectDocument updateCelestialObject(String name, CelestialObjectDocument updatedData) {
        CelestialObjectDocument existing = celestialObjectsRepository.findByName(name);
        if (existing == null) {
            throw new RuntimeException("Celestial object not found with name: " + name);
        }
        updatedData.setId(existing.getId());
        return celestialObjectsRepository.save(updatedData);
    }

    @Override
    public boolean deleteCelestialObjectByName(String name) {
        CelestialObjectDocument existing = celestialObjectsRepository.findByName(name);
        if (existing == null) {
            return false;
        }
        celestialObjectsRepository.delete(existing);
        return true;
    }
}
