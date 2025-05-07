package com.danilo.volles.celestial.objects.api.persistence.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "dwarfPlanets")
public class DwarfPlanetDocument extends CelestialObjectDocument {
    private double orbitalInclination;
    private boolean hasRingSystem;
}
