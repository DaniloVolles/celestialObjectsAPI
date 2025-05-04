package com.danilo.volles.celestial.objects.api.persistence.repository;

import com.danilo.volles.celestial.objects.api.persistence.document.PlanetDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends MongoRepository<PlanetDocument, String> {}

