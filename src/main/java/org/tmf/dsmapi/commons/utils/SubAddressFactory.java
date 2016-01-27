/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.commons.utils;

import java.util.ArrayList;
import java.util.List;
import org.tmf.dsmapi.address.model.SubAddress;

/**
 *
 * @author ECUS6396
 */
public class SubAddressFactory {
    
    
    public static List<SubAddress> createListeSubAddress(){
        List<SubAddress> l_subAddress = new ArrayList<SubAddress>();
        SubAddress subAddress = new SubAddress();
        subAddress.setId("76608281");
        subAddress.setHref("http://localhost:8080/DSAddressManagement/api/addressManagement/v1/subAddress/76608281");
        subAddress.setType("");
        subAddress.setName("Flat 39");
        subAddress.setSubUnitType("flat");
        subAddress.setSubUnitNumber("39");
        subAddress.setLevelType("floor");
        subAddress.setLevelNumber("3");
        subAddress.setBuildingName("Building C");
        subAddress.setPrivateStreetName("");
        subAddress.setPrivateStreetNumber("");
        l_subAddress.add(subAddress);
        
        subAddress = new SubAddress();
        subAddress.setId("76608282");
        subAddress.setHref("http://localhost:8080/DSAddressManagement/api/addressManagement/v1/subAddress/76608282");
        subAddress.setType("");
        subAddress.setName("Flat 40");
        subAddress.setSubUnitType("flat");
        subAddress.setSubUnitNumber("40");
        subAddress.setLevelType("floor");
        subAddress.setLevelNumber("3");
        subAddress.setBuildingName("Building C");
        subAddress.setPrivateStreetName("");
        subAddress.setPrivateStreetNumber("");
        l_subAddress.add(subAddress);
        
        subAddress = new SubAddress();
        subAddress.setId("76608283");
        subAddress.setHref("http://localhost:8080/DSAddressManagement/api/addressManagement/v1/subAddress/76608283");
        subAddress.setType("");
        subAddress.setName("Flat 42");
        subAddress.setSubUnitType("flat");
        subAddress.setSubUnitNumber("42");
        subAddress.setLevelType("floor");
        subAddress.setLevelNumber("3");
        subAddress.setBuildingName("Building C");
        subAddress.setPrivateStreetName("");
        subAddress.setPrivateStreetNumber("");
        l_subAddress.add(subAddress);
        
        return l_subAddress;
    }
    
}
