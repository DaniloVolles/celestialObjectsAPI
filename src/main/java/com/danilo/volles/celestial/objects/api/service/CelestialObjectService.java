package com.danilo.volles.celestial.objects.api.service;

import com.danilo.volles.celestial.objects.api.persistence.document.CelestialObjectDocument;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CelestialObjectService {

    // POST
    CelestialObjectDocument saveCelestialObject(CelestialObjectDocument celestialObject);

    // GET
    CelestialObjectDocument getCelestialObjectByName(String name);
    List<CelestialObjectDocument> getAllCelestialObjects();
    List<CelestialObjectDocument> getCelestialObjectsByType(String type);

    // UPDATE
    CelestialObjectDocument updateCelestialObject(String name, CelestialObjectDocument updatedData);

    // DELETE
    boolean deleteCelestialObjectByName(String name);
}
