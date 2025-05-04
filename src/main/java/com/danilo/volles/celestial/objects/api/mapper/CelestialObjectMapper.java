package com.danilo.volles.celestial.objects.api.mapper;

import com.danilo.volles.celestial.objects.api.persistence.document.CelestialObjectDocument;
import com.danilovolles.celestialobjects.CelestialObject;
import com.danilovolles.celestialobjects.Moon;
import com.danilovolles.celestialobjects.Planet;
import com.danilovolles.celestialobjects.Star;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CelestialObjectMapper {
    CelestialObjectDocument toEntity(CelestialObject dto);

    default CelestialObject toDto(CelestialObjectDocument entity) {
        return switch (entity.getCelestialObjectType()) {
            case STAR -> mapToStar(entity);
            case PLANET -> mapToPlanet(entity);
            case MOON -> mapToMoon(entity);
            default -> throw new IllegalArgumentException("Tipo desconhecido: " + entity.getCelestialObjectType());
        };
    }

    Star mapToStar(CelestialObjectDocument entity);
    Planet mapToPlanet(CelestialObjectDocument entity);
    Moon mapToMoon(CelestialObjectDocument entity);
}
