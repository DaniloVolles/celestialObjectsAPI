package com.danilo.volles.celestial.objects.api.mapper;

import com.danilo.volles.celestial.objects.api.persistence.document.MoonDocument;
import com.danilovolles.celestialobjects.Moon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MoonMapper {
    MoonDocument toEntity(Moon dto);
    Moon toDto(MoonDocument entity);
}
