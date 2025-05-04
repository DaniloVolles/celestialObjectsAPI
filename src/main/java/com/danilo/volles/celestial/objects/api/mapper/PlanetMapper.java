package com.danilo.volles.celestial.objects.api.mapper;

import com.danilo.volles.celestial.objects.api.persistence.document.PlanetDocument;
import com.danilovolles.celestialobjects.Planet;

public class PlanetMapper {

    public static PlanetDocument toDocument(Planet dto) {
        PlanetDocument doc = new PlanetDocument();
        doc.setName(dto.getName());
        doc.setCelestialObjectType(dto.getCelestialObjectType());
        doc.setMass(dto.getMass());
        doc.setMeanDistanceToCenter(dto.getMeanDistanceToCenter());
        doc.setHasAtmosphere(dto.isHasAtmosphere());
        doc.setHabitable(dto.isHabitable());
        return doc;
    }

    public static Planet toDto(PlanetDocument doc) {
        Planet dto = new Planet();
        dto.setName(doc.getName());
        dto.setCelestialObjectType(doc.getCelestialObjectType());
        dto.setMass(doc.getMass());
        dto.setMeanDistanceToCenter(doc.getMeanDistanceToCenter());
        dto.setHasAtmosphere(doc.isHasAtmosphere());
        dto.setHabitable(doc.isHabitable());
        return dto;
    }
}
