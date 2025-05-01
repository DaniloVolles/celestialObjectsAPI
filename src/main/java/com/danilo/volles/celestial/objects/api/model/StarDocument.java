package com.danilo.volles.celestial.objects.api.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "stars")
public class StarDocument extends CelestialObjectDocument{
    private double temperature;
    private String spectralType;
}
