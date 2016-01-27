package org.tmf.dsmapi;

import org.glassfish.jersey.server.ResourceConfig;
import org.tmf.dsmapi.commons.jaxrs.JacksonFeature;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig(){
        packages ("com.fasterxml.jackson.jaxrs.json");
        register(JacksonFeature.class);
        register(org.tmf.dsmapi.commons.jaxrs.BadUsageExceptionMapper.class);
        register(org.tmf.dsmapi.commons.jaxrs.JacksonConfigurator.class);
        register(org.tmf.dsmapi.commons.jaxrs.JsonMappingExceptionMapper.class);
        register(org.tmf.dsmapi.commons.jaxrs.UnknowResourceExceptionMapper.class);
        register(org.tmf.dsmapi.commons.jaxrs.UnknowResourceExceptionMapper.class);
        register(org.tmf.dsmapi.hub.HubResource.class);
        register(org.tmf.dsmapi.address.AddressResource.class);
        register(org.tmf.dsmapi.address.AddressAdminResource.class);
        register(org.tmf.dsmapi.subAddress.SubAddressResource.class);
        register(org.tmf.dsmapi.subAddress.SubAddressAdminResource.class);
        register(org.tmf.dsmapi.area.AreaResource.class);
        register(org.tmf.dsmapi.area.AreaAdminResource.class);
        register(org.tmf.dsmapi.street.StreetResource.class);
        register(org.tmf.dsmapi.street.StreetAdminResource.class);
        register(org.tmf.dsmapi.streetSegment.StreetSegmentResource.class);
        register(org.tmf.dsmapi.streetSegment.StreetSegmentAdminResource.class);
    }

}
