//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.12.24 à 01:44:15 PM CET 
//


package org.tmf.dsmapi.address.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * Structured textual way of describing how to find a Property in an urban area (country properties are often defined differently).
 * 
 * <p>Classe Java pour Address complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Address">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subAddress" type="{http://orange.com/api/addressManagement/tmf/v1/model/business}SubAddressRef" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="href" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="streetNr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="streetNrSuffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="streetNrLast" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="streetNrLastSuffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="streetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="streetType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="streetSuffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="locality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stateOrProvince" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="geoCode" type="{http://orange.com/api/addressManagement/tmf/v1/model/business}GeoCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Address", propOrder = {
    "id",
    "subAddress",
    "href",
    "streetNr",
    "streetNrSuffix",
    "streetNrLast",
    "streetNrLastSuffix",
    "streetName",
    "streetType",
    "streetSuffix",
    "postcode",
    "locality",
    "city",
    "stateOrProvince",
    "country",
    "geoCode"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "Address")
@Table(name = "ADDRESS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(length = 127)
public class Address
    implements Serializable
{

    private final static long serialVersionUID = 11L;
    protected String id;
    protected List<SubAddressRef> subAddress;
    protected String href;
    protected String streetNr;
    protected String streetNrSuffix;
    protected String streetNrLast;
    protected String streetNrLastSuffix;
    protected String streetName;
    protected String streetType;
    protected String streetSuffix;
    protected String postcode;
    protected String locality;
    protected String city;
    protected String stateOrProvince;
    protected String country;
    protected GeoCode geoCode;

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the subAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubAddressRef }
     * 
     * 
     */
    @OneToMany(targetEntity = SubAddressRef.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "SUB_ADDRESS_ADDRESS_ID")
    public List<SubAddressRef> getSubAddress() {
        if (subAddress == null) {
            subAddress = new ArrayList<SubAddressRef>();
        }
        return this.subAddress;
    }

    /**
     * 
     * 
     */
    public void setSubAddress(List<SubAddressRef> subAddress) {
        this.subAddress = subAddress;
    }

    /**
     * Obtient la valeur de la propriété href.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "HREF", length = 255)
    public String getHref() {
        return href;
    }

    /**
     * Définit la valeur de la propriété href.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Obtient la valeur de la propriété streetNr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "STREET_NR", length = 255)
    public String getStreetNr() {
        return streetNr;
    }

    /**
     * Définit la valeur de la propriété streetNr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNr(String value) {
        this.streetNr = value;
    }

    /**
     * Obtient la valeur de la propriété streetNrSuffix.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "STREET_NR_SUFFIX", length = 255)
    public String getStreetNrSuffix() {
        return streetNrSuffix;
    }

    /**
     * Définit la valeur de la propriété streetNrSuffix.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNrSuffix(String value) {
        this.streetNrSuffix = value;
    }

    /**
     * Obtient la valeur de la propriété streetNrLast.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "STREET_NR_LAST", length = 255)
    public String getStreetNrLast() {
        return streetNrLast;
    }

    /**
     * Définit la valeur de la propriété streetNrLast.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNrLast(String value) {
        this.streetNrLast = value;
    }

    /**
     * Obtient la valeur de la propriété streetNrLastSuffix.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "STREET_NR_LAST_SUFFIX", length = 255)
    public String getStreetNrLastSuffix() {
        return streetNrLastSuffix;
    }

    /**
     * Définit la valeur de la propriété streetNrLastSuffix.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNrLastSuffix(String value) {
        this.streetNrLastSuffix = value;
    }

    /**
     * Obtient la valeur de la propriété streetName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "STREET_NAME", length = 255)
    public String getStreetName() {
        return streetName;
    }

    /**
     * Définit la valeur de la propriété streetName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetName(String value) {
        this.streetName = value;
    }

    /**
     * Obtient la valeur de la propriété streetType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "STREET_TYPE", length = 255)
    public String getStreetType() {
        return streetType;
    }

    /**
     * Définit la valeur de la propriété streetType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetType(String value) {
        this.streetType = value;
    }

    /**
     * Obtient la valeur de la propriété streetSuffix.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "STREET_SUFFIX", length = 255)
    public String getStreetSuffix() {
        return streetSuffix;
    }

    /**
     * Définit la valeur de la propriété streetSuffix.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetSuffix(String value) {
        this.streetSuffix = value;
    }

    /**
     * Obtient la valeur de la propriété postcode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "POSTCODE", length = 255)
    public String getPostcode() {
        return postcode;
    }

    /**
     * Définit la valeur de la propriété postcode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostcode(String value) {
        this.postcode = value;
    }

    /**
     * Obtient la valeur de la propriété locality.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "LOCALITY", length = 255)
    public String getLocality() {
        return locality;
    }

    /**
     * Définit la valeur de la propriété locality.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocality(String value) {
        this.locality = value;
    }

    /**
     * Obtient la valeur de la propriété city.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "CITY", length = 255)
    public String getCity() {
        return city;
    }

    /**
     * Définit la valeur de la propriété city.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Obtient la valeur de la propriété stateOrProvince.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "STATE_OR_PROVINCE", length = 255)
    public String getStateOrProvince() {
        return stateOrProvince;
    }

    /**
     * Définit la valeur de la propriété stateOrProvince.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateOrProvince(String value) {
        this.stateOrProvince = value;
    }

    /**
     * Obtient la valeur de la propriété country.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "COUNTRY", length = 255)
    public String getCountry() {
        return country;
    }

    /**
     * Définit la valeur de la propriété country.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Obtient la valeur de la propriété geoCode.
     * 
     * @return
     *     possible object is
     *     {@link GeoCode }
     *     
     */
    @ManyToOne(targetEntity = GeoCode.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "GEO_CODE_ADDRESS_HJID")
    public GeoCode getGeoCode() {
        return geoCode;
    }

    /**
     * Définit la valeur de la propriété geoCode.
     * 
     * @param value
     *     allowed object is
     *     {@link GeoCode }
     *     
     */
    public void setGeoCode(GeoCode value) {
        this.geoCode = value;
    }

}
