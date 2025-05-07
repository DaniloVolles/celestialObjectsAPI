package com.danilo.volles.celestial.objects.api.endpoint;

import com.danilo.volles.celestial.objects.api.mapper.CelestialObjectMapper;
import com.danilo.volles.celestial.objects.api.persistence.document.CelestialObjectDocument;
import com.danilo.volles.celestial.objects.api.service.CelestialObjectService;
import com.danilovolles.celestialobjects.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CelestialObjEndpoint {

    private static final String NAMESPACE_URI = "http://www.danilovolles.com/celestialObjects";

    private final CelestialObjectService celestialObjectService;
    private final CelestialObjectMapper mapper;

    public CelestialObjEndpoint(CelestialObjectService celestialObjectService, CelestialObjectMapper mapper) {
        this.celestialObjectService = celestialObjectService;
        this.mapper = mapper;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SaveCelestialObjectRequest")
    @ResponsePayload
    public SaveCelestialObjectResponse saveCelestialObject(@RequestPayload SaveCelestialObjectRequest request) {
        CelestialObjectDocument entity = mapper.toEntity(request.getCelestialObject());
        CelestialObjectDocument saved = celestialObjectService.saveCelestialObject(entity);
        CelestialObject dto = mapper.toDto(saved);

        SaveCelestialObjectResponse response = new SaveCelestialObjectResponse();
        response.setCelestialObject(dto);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCelestialObjectByNameRequest")
    @ResponsePayload
    public GetCelestialObjectByNameResponse getCelestialObjectByName(
            @RequestPayload GetCelestialObjectByNameRequest request
    ) {
        CelestialObjectDocument document = celestialObjectService.getCelestialObjectByName(request.getName());

        if (document == null) {
            return new GetCelestialObjectByNameResponse();
        }

        CelestialObject celestialObject = mapper.toDto(document);

        GetCelestialObjectByNameResponse response = new GetCelestialObjectByNameResponse();
        response.setCelestialObject(celestialObject);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCelestialObjectByTypeRequest")
    @ResponsePayload
    public GetCelestialObjectByTypeResponse getCelestialObjectsByType(
            @RequestPayload GetCelestialObjectByTypeRequest request
    ) {
        var type = request.getCelestialObjectType().value(); // assumindo que é um enum
        var documents = celestialObjectService.getCelestialObjectsByType(type);

        GetCelestialObjectByTypeResponse response = new GetCelestialObjectByTypeResponse();
        for (CelestialObjectDocument doc : documents) {
            CelestialObject dto = mapper.toDto(doc);
            response.getCelestialObjects().add(dto);
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllCelestialObjectsRequest")
    @ResponsePayload
    public GetAllCelestialObjectsResponse getAllCelestialObjects() {
        var documents = celestialObjectService.getAllCelestialObjects();

        GetAllCelestialObjectsResponse response = new GetAllCelestialObjectsResponse();
        for (CelestialObjectDocument doc : documents) {
            CelestialObject dto = mapper.toDto(doc);
            response.getCelestialObjects().add(dto);
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateCelestialObjectRequest")
    @ResponsePayload
    public UpdateCelestialObjectResponse updateCelestialObject(
            @RequestPayload UpdateCelestialObjectRequest request
    ) {
        String name = request.getName();
        CelestialObjectDocument updatedEntity = mapper.toEntity(request.getCelestialObject());

        CelestialObjectDocument updated = celestialObjectService.updateCelestialObject(name, updatedEntity);

        UpdateCelestialObjectResponse response = new UpdateCelestialObjectResponse();
        response.setCelestialObject(mapper.toDto(updated));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteCelestialObjectRequest")
    @ResponsePayload
    public DeleteCelestialObjectResponse deleteCelestialObject(
            @RequestPayload DeleteCelestialObjectRequest request
    ) {
        boolean success = celestialObjectService.deleteCelestialObjectByName(request.getName());

        DeleteCelestialObjectResponse response = new DeleteCelestialObjectResponse();
        response.setSuccess(success);

        return response;
    }

}
