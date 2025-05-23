package com.danilo.volles.celestial.objects.api.persistence.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "planets")
public class PlanetDocument extends CelestialObjectDocument {
    private boolean hasAtmosphere;
    private boolean habitable;
    private List<MoonDocument> moons;
}
