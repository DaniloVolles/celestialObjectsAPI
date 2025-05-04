package com.danilo.volles.celestial.objects.api.service;

import com.danilo.volles.celestial.objects.api.persistence.document.CelestialObjectDocument;
import com.danilovolles.celestialobjects.CelestialObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CelestialObjectService {

    CelestialObjectDocument saveCelestialObject(CelestialObjectDocument celestialObject);
    CelestialObjectDocument getCelestialObject(String name);
    List<CelestialObjectDocument> getAllCelestialObjects();
}
