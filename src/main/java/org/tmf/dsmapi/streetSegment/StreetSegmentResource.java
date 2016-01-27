package org.tmf.dsmapi.streetSegment;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.commons.utils.Jackson;
import org.tmf.dsmapi.commons.utils.URIParser;
import org.tmf.dsmapi.address.model.StreetSegment;
import org.tmf.dsmapi.streetSegment.StreetSegmentFacade;
import org.tmf.dsmapi.streetSegment.event.StreetSegmentEventPublisherLocal;

@Stateless
@Path("/addressManagement/v1/streetSegment")
public class StreetSegmentResource {

    @EJB
    StreetSegmentFacade streetSegmentFacade;
    @EJB
    StreetSegmentEventPublisherLocal publisher;

    public StreetSegmentResource() {
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

        Set<StreetSegment> resultList = findByCriteria(mutableMap);

        Response response;
        if (fieldSet.isEmpty() || fieldSet.contains(URIParser.ALL_FIELDS)) {
            response = Response.ok(resultList).build();
        } else {
            fieldSet.add(URIParser.ID_FIELD);
            List<ObjectNode> nodeList = Jackson.createNodes(resultList, fieldSet);
            response = Response.ok(nodeList).build();
        }
        return response;
    }

    // return Set of unique elements to avoid List with same elements in case of join
    private Set<StreetSegment> findByCriteria(Map<String, List<String>> criteria) throws BadUsageException {

        List<StreetSegment> resultList = null;
        if (criteria != null && !criteria.isEmpty()) {
            resultList = streetSegmentFacade.findByCriteria(criteria, StreetSegment.class);
        } else {
            resultList = streetSegmentFacade.findAll();
        }
        if (resultList == null) {
            return new LinkedHashSet<StreetSegment>();
        } else {
            return new LinkedHashSet<StreetSegment>(resultList);
        }
    }






}
