package com.danilo.volles.celestial.objects.api.mapper;

import com.danilo.volles.celestial.objects.api.persistence.document.CelestialObjectDocument;
import com.danilovolles.celestialobjects.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CelestialObjectMapper {
    CelestialObjectDocument toEntity(CelestialObject dto);

    default CelestialObject toDto(CelestialObjectDocument entity) {
        return switch (entity.getCelestialObjectType()) {
            case STAR -> mapToStar(entity);
            case PLANET -> mapToPlanet(entity);
            case MOON -> mapToMoon(entity);
            case ASTEROID -> mapToAsteroid(entity);
            case COMET -> mapToComet(entity);
            case DWARF_PLANET -> mapToDwarfPlanet(entity);
            case OTHER -> mapToOther(entity);
        };
    }

    Star mapToStar(CelestialObjectDocument entity);
    Planet mapToPlanet(CelestialObjectDocument entity);
    Moon mapToMoon(CelestialObjectDocument entity);
    Asteroid mapToAsteroid(CelestialObjectDocument entity);
    Comet mapToComet(CelestialObjectDocument entity);
    DwarfPlanet mapToDwarfPlanet(CelestialObjectDocument entity);
    Other mapToOther(CelestialObjectDocument entity);
}
