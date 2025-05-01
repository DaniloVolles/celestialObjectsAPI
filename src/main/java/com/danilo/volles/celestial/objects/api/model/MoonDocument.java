package com.danilo.volles.celestial.objects.api.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "moons")
public class MoonDocument extends CelestialObjectDocument {
    private PlanetDocument hostPlanet;
}
