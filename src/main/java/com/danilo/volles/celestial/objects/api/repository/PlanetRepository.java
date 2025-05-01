package com.danilo.volles.celestial.objects.api.repository;

import com.danilo.volles.celestial.objects.api.model.MoonDocument;
import com.danilo.volles.celestial.objects.api.model.PlanetDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends MongoRepository<PlanetDocument, String> {}

