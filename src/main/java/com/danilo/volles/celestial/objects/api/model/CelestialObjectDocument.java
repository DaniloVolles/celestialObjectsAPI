package com.danilo.volles.celestial.objects.api.model;

import com.danilovolles.celestialobjects.CelestialObjectType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "celestialObjects")
public class CelestialObjectDocument {

    @Id
    private String id;

    private String name;
    private CelestialObjectType celestialObjectType;
    private double mass;
    private double diameter;
    private double superficialGravity;
    private double meanDistanceToCenter;
}
