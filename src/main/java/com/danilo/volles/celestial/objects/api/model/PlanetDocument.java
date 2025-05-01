package com.danilo.volles.celestial.objects.api.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "planets")
public class PlanetDocument extends CelestialObjectDocument {
    private boolean hasAtmosphere;
    private boolean habitable;
    private List<MoonDocument> moons;
}
