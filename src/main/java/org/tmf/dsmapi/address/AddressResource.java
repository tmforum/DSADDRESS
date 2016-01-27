package org.tmf.dsmapi.address;

import java.util.HashMap;
import java.util.Map;
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
import java.util.ArrayList;
import javax.ws.rs.POST;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.commons.utils.Jackson;
import org.tmf.dsmapi.commons.utils.URIParser;
import org.tmf.dsmapi.address.model.Address;
import org.tmf.dsmapi.address.event.AddressEventPublisherLocal;
import org.tmf.dsmapi.address.model.SubAddress;
import org.tmf.dsmapi.commons.exceptions.FunctionalException;
import org.tmf.dsmapi.subAddress.SubAddressFacade;

@Stateless
@Path("/addressManagement/v1/address")
public class AddressResource {

    @EJB
    AddressFacade addressFacade;
    @EJB
    SubAddressFacade subAddressFacade;
    @EJB
    AddressEventPublisherLocal publisher;

    public AddressResource() {
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

        Set<Address> resultList = findByCriteria(mutableMap);

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
    private Set<Address> findByCriteria(Map<String, List<String>> criteria) throws BadUsageException {

        List<Address> resultList = null;
        if (criteria != null && !criteria.isEmpty()) {
            resultList = addressFacade.findByCriteria(criteria, Address.class);
        } else {
            resultList = addressFacade.findAll();
        }
        if (resultList == null) {
            return new LinkedHashSet<Address>();
        } else {
            return new LinkedHashSet<Address>(resultList);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Response get(@PathParam("id") String id, @Context UriInfo info) throws UnknownResourceException {

        // search queryParameters
        MultivaluedMap<String, String> queryParameters = info.getQueryParameters();

        Map<String, List<String>> mutableMap = new HashMap();
        for (Map.Entry<String, List<String>> e : queryParameters.entrySet()) {
            mutableMap.put(e.getKey(), e.getValue());
        }

        // fields to filter view
        Set<String> fieldSet = URIParser.getFieldsSelection(mutableMap);

        Address address = addressFacade.find(id);
        Response response;

        // If the result list (list of bills) is not empty, it conains only 1 unique bill
        if (address != null) {
            // 200
            if (fieldSet.isEmpty() || fieldSet.contains(URIParser.ALL_FIELDS)) {
                response = Response.ok(address).build();
            } else {
                fieldSet.add(URIParser.ID_FIELD);
                ObjectNode node = Jackson.createNode(address, fieldSet);
                response = Response.ok(node).build();
            }
        } else {
            // 404 not found
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        return response;
    }

    @POST
    @Path("/validate")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response validate(Address entity) throws BadUsageException, UnknownResourceException {
        addressFacade.validate(entity);
//        entity.setHref(info.getAbsolutePath() + "/" + Long.toString(entity.getId()));
//        subscriptionFacade.edit(entity);
//        publisher.createNotification(entity, new Date());
//        subscriptionFacade.edit(entity);
        // 201
        Response response = Response.status(Response.Status.CREATED).entity(entity).build();
        return response;
    }

    @GET
    @Path("/{addressId}/subAddress")
    @Produces({"application/json"})
    public Response findSubAddress(@PathParam("addressId") String addressId, @Context UriInfo info) throws BadUsageException, UnknownResourceException {

        
        List<SubAddress> resultList = addressFacade.findSubAddress(addressId);

        //BOUCHON
//        List<SubAddress> resultList = new ArrayList<SubAddress>();
//        if (addressId.equals("76608281")) {
//            resultList = SubAddressFactory.createListeSubAddress();
//        }

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
            response = Response.ok(resultList).build();
        } else {
            fieldSet.add(URIParser.ID_FIELD);
            List<ObjectNode> nodeList = Jackson.createNodes(resultList, fieldSet);
            response = Response.ok(nodeList).build();
        }
        return response;
    }

    @GET
    @Path("/{addressId}/subAddress/{subAddressId}")
    @Produces({"application/json"})
    public Response getSubAddress(@PathParam("addressId") String addressId, @PathParam("subAddressId") String subAddressId, @Context UriInfo info) throws BadUsageException, UnknownResourceException, FunctionalException {

        SubAddress result = addressFacade.getSubAddress(addressId, subAddressId);
        //BOUCHON
        //TODO

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
            response = Response.ok(result).build();
        } else {
            fieldSet.add(URIParser.ID_FIELD);
            List<SubAddress> resultList = new ArrayList<SubAddress>();
            resultList.add(result);
            List<ObjectNode> nodeList = Jackson.createNodes(resultList, fieldSet);
            response = Response.ok(nodeList).build();
        }
        return response;
    }

}
