package org.tmf.dsmapi.street;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.ws.rs.PathParam;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.utils.Jackson;
import org.tmf.dsmapi.commons.utils.URIParser;
import org.tmf.dsmapi.address.model.Street;
import org.tmf.dsmapi.address.model.StreetSegment;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.street.StreetFacade;
import org.tmf.dsmapi.street.event.StreetEventPublisherLocal;
import org.tmf.dsmapi.streetSegment.StreetSegmentFacade;

@Stateless
@Path("/addressManagement/v1/street")
public class StreetResource {

    @EJB
    StreetFacade streetFacade;
    @EJB
    StreetSegmentFacade streetSegmentFacade;
    @EJB
    StreetEventPublisherLocal publisher;

    public StreetResource() {
    }

    @GET
    @Produces({"application/json"})
    public Response find(@Context UriInfo info) throws BadUsageException {

        // search queryParameters
        MultivaluedMap<String, String> queryParameters = info.getQueryParameters();

        Map<String, List<String>> mutableMap = new HashMap();
        for (Map.Entry<String, List<String>> e : queryParameters.entrySet()) {
            mutableMap.put(e.getKey(), e.getValue());
        }

        // fields to filter view
        Set<String> fieldSet = URIParser.getFieldsSelection(mutableMap);

        Set<Street> resultList = findByCriteria(mutableMap);

        Response response;
        if (fieldSet.isEmpty() || fieldSet.contains(URIParser.ALL_FIELDS)) {
            fieldSet.add("id");
            fieldSet.add("type");
            fieldSet.add("name");
            List<ObjectNode> nodeList = Jackson.createNodes(resultList, fieldSet);
            response = Response.ok(nodeList).build();
//            response = Response.ok(resultList).build();
        } else {
            fieldSet.add(URIParser.ID_FIELD);
            List<ObjectNode> nodeList = Jackson.createNodes(resultList, fieldSet);
            response = Response.ok(nodeList).build();
        }
        return response;
    }

    // return Set of unique elements to avoid List with same elements in case of join
    private Set<Street> findByCriteria(Map<String, List<String>> criteria) throws BadUsageException {

        List<Street> resultList = null;
        if (criteria != null && !criteria.isEmpty()) {
            resultList = streetFacade.findByCriteria(criteria, Street.class);
        } else {
            resultList = streetFacade.findAll();
        }
        if (resultList == null) {
            return new LinkedHashSet<Street>();
        } else {
            return new LinkedHashSet<Street>(resultList);
        }
    }

    @GET
    @Path("/{streetId}/streetSegment")
    @Produces({"application/json"})
    public Response findStreetSegment(@PathParam("streetId") String streetId, @Context UriInfo info) throws BadUsageException, UnknownResourceException {

        List<StreetSegment> resultList = streetSegmentFacade.findAllStreetSegmentWithStreetId(streetId);

        //BOUCHON
        // search queryParameters
        MultivaluedMap<String, String> queryParameters = info.getQueryParameters();

        Map<String, List<String>> mutableMap = new HashMap();
        for (Map.Entry<String, List<String>> e : queryParameters.entrySet()) {
            mutableMap.put(e.getKey(), e.getValue());
        }

        // fields to filter view
        Set<String> fieldSet = URIParser.getFieldsSelection(mutableMap);

//        Set<SubAddress> resultList = findByCriteria(mutableMap);
        Response response;
        if (fieldSet.isEmpty() || fieldSet.contains(URIParser.ALL_FIELDS)) {
            fieldSet.add("id");
            fieldSet.add("number");
            fieldSet.add("numberSuffix");
            fieldSet.add("numberLast");
            fieldSet.add("numberLastSuffix");
            fieldSet.add("address");
            response = Response.ok(resultList).build();
        } else {
            fieldSet.add(URIParser.ID_FIELD);
            List<ObjectNode> nodeList = Jackson.createNodes(resultList, fieldSet);
            response = Response.ok(nodeList).build();
        }
        return response;
    }

}
