package com.danilo.volles.celestial.objects.api.repository;

import com.danilo.volles.celestial.objects.api.model.MoonDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoonRepository extends MongoRepository<MoonDocument, String> {}

