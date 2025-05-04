package com.danilo.volles.celestial.objects.api.persistence.repository;

import com.danilo.volles.celestial.objects.api.persistence.document.CelestialObjectDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelestialObjectsDocument extends MongoRepository<CelestialObjectDocument, String> {
}
