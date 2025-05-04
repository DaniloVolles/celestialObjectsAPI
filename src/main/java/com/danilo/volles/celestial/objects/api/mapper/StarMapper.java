package com.danilo.volles.celestial.objects.api.mapper;

import com.danilo.volles.celestial.objects.api.persistence.document.StarDocument;
import com.danilovolles.celestialobjects.Star;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StarMapper {
    StarDocument toEntity(Star dto);
    Star toDto(StarDocument entity);
}
