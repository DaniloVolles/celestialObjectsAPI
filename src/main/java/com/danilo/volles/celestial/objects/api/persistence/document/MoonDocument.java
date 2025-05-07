package com.danilo.volles.celestial.objects.api.persistence.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "moons")
public class MoonDocument extends CelestialObjectDocument {
    private PlanetDocument hostPlanet;
}
