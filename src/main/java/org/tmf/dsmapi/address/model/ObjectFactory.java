//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.12.24 à 01:44:15 PM CET 
//


package org.tmf.dsmapi.address.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tmf.dsmapi.address.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GeoCode_QNAME = new QName("http://orange.com/api/addressManagement/tmf/v1/model/business", "GeoCode");
    private final static QName _SubAddress_QNAME = new QName("http://orange.com/api/addressManagement/tmf/v1/model/business", "SubAddress");
    private final static QName _Characteristic_QNAME = new QName("http://orange.com/api/addressManagement/tmf/v1/model/business", "Characteristic");
    private final static QName _Street_QNAME = new QName("http://orange.com/api/addressManagement/tmf/v1/model/business", "Street");
    private final static QName _StreetSegment_QNAME = new QName("http://orange.com/api/addressManagement/tmf/v1/model/business", "StreetSegment");
    private final static QName _AddressRef_QNAME = new QName("http://orange.com/api/addressManagement/tmf/v1/model/business", "AddressRef");
    private final static QName _Address_QNAME = new QName("http://orange.com/api/addressManagement/tmf/v1/model/business", "Address");
    private final static QName _SubAddressRef_QNAME = new QName("http://orange.com/api/addressManagement/tmf/v1/model/business", "SubAddressRef");
    private final static QName _Area_QNAME = new QName("http://orange.com/api/addressManagement/tmf/v1/model/business", "Area");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tmf.dsmapi.address.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Characteristic }
     * 
     */
    public Characteristic createCharacteristic() {
        return new Characteristic();
    }

    /**
     * Create an instance of {@link StreetSegment }
     * 
     */
    public StreetSegment createStreetSegment() {
        return new StreetSegment();
    }

    /**
     * Create an instance of {@link Street }
     * 
     */
    public Street createStreet() {
        return new Street();
    }

    /**
     * Create an instance of {@link AddressRef }
     * 
     */
    public AddressRef createAddressRef() {
        return new AddressRef();
    }

    /**
     * Create an instance of {@link Area }
     * 
     */
    public Area createArea() {
        return new Area();
    }

    /**
     * Create an instance of {@link SubAddressRef }
     * 
     */
    public SubAddressRef createSubAddressRef() {
        return new SubAddressRef();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link SubAddress }
     * 
     */
    public SubAddress createSubAddress() {
        return new SubAddress();
    }

    /**
     * Create an instance of {@link GeoCode }
     * 
     */
    public GeoCode createGeoCode() {
        return new GeoCode();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeoCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/addressManagement/tmf/v1/model/business", name = "GeoCode")
    public JAXBElement<GeoCode> createGeoCode(GeoCode value) {
        return new JAXBElement<GeoCode>(_GeoCode_QNAME, GeoCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/addressManagement/tmf/v1/model/business", name = "SubAddress")
    public JAXBElement<SubAddress> createSubAddress(SubAddress value) {
        return new JAXBElement<SubAddress>(_SubAddress_QNAME, SubAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Characteristic }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/addressManagement/tmf/v1/model/business", name = "Characteristic")
    public JAXBElement<Characteristic> createCharacteristic(Characteristic value) {
        return new JAXBElement<Characteristic>(_Characteristic_QNAME, Characteristic.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Street }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/addressManagement/tmf/v1/model/business", name = "Street")
    public JAXBElement<Street> createStreet(Street value) {
        return new JAXBElement<Street>(_Street_QNAME, Street.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StreetSegment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/addressManagement/tmf/v1/model/business", name = "StreetSegment")
    public JAXBElement<StreetSegment> createStreetSegment(StreetSegment value) {
        return new JAXBElement<StreetSegment>(_StreetSegment_QNAME, StreetSegment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressRef }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/addressManagement/tmf/v1/model/business", name = "AddressRef")
    public JAXBElement<AddressRef> createAddressRef(AddressRef value) {
        return new JAXBElement<AddressRef>(_AddressRef_QNAME, AddressRef.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/addressManagement/tmf/v1/model/business", name = "Address")
    public JAXBElement<Address> createAddress(Address value) {
        return new JAXBElement<Address>(_Address_QNAME, Address.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubAddressRef }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/addressManagement/tmf/v1/model/business", name = "SubAddressRef")
    public JAXBElement<SubAddressRef> createSubAddressRef(SubAddressRef value) {
        return new JAXBElement<SubAddressRef>(_SubAddressRef_QNAME, SubAddressRef.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Area }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://orange.com/api/addressManagement/tmf/v1/model/business", name = "Area")
    public JAXBElement<Area> createArea(Area value) {
        return new JAXBElement<Area>(_Area_QNAME, Area.class, null, value);
    }

}
