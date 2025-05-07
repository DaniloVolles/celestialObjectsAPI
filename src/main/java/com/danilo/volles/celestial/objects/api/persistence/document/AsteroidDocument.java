package com.danilo.volles.celestial.objects.api.persistence.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "asteroids")
public class AsteroidDocument extends CelestialObjectDocument {
    private double orbitalPeriod;
    private double rotationPeriod;
    private String composition;
}
