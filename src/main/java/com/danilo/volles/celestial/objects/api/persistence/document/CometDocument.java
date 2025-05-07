package com.danilo.volles.celestial.objects.api.persistence.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "comets")
public class CometDocument extends CelestialObjectDocument {
    private double tailLength;
    private double perihelionDistance;
    private double comaSize;
}
