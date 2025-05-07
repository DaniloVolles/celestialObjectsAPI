package com.danilo.volles.celestial.objects.api.persistence.repository;

import com.danilo.volles.celestial.objects.api.persistence.document.CelestialObjectDocument;
import com.danilovolles.celestialobjects.CelestialObjectType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CelestialObjectsRepository extends MongoRepository<CelestialObjectDocument, String> {
    CelestialObjectDocument findByName(String name);
    List<CelestialObjectDocument> findAllByCelestialObjectType(CelestialObjectType celestialObjectType);
}
