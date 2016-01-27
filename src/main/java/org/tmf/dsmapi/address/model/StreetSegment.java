//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.12.24 à 01:44:15 PM CET 
//


package org.tmf.dsmapi.address.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.OneToMany;


/**
 * It is used to represent segments in a given street: this can be directly street numbers (22), or group of numbers materializing a geographic address, e.g. 22-24.
 * 
 * <p>Classe Java pour StreetSegment complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="StreetSegment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberSuffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberLast" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberLastSuffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address" type="{http://orange.com/api/addressManagement/tmf/v1/model/business}AddressRef" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StreetSegment", propOrder = {
    "id",
    "number",
    "numberSuffix",
    "numberLast",
    "numberLastSuffix",
    "address"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "StreetSegment")
@Table(name = "STREET_SEGMENT")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(length = 127)
public class StreetSegment
    implements Serializable
{

    private final static long serialVersionUID = 11L;
    protected String id;
    protected String number;
    protected String numberSuffix;
    protected String numberLast;
    protected String numberLastSuffix;
    protected AddressRef address;
    protected Reference street;

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
     * Obtient la valeur de la propriété number.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "NUMBER_", length = 255)
    public String getNumber() {
        return number;
    }

    /**
     * Définit la valeur de la propriété number.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Obtient la valeur de la propriété numberSuffix.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "NUMBER_SUFFIX", length = 255)
    public String getNumberSuffix() {
        return numberSuffix;
    }

    /**
     * Définit la valeur de la propriété numberSuffix.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberSuffix(String value) {
        this.numberSuffix = value;
    }

    /**
     * Obtient la valeur de la propriété numberLast.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "NUMBER_LAST", length = 255)
    public String getNumberLast() {
        return numberLast;
    }

    /**
     * Définit la valeur de la propriété numberLast.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberLast(String value) {
        this.numberLast = value;
    }

    /**
     * Obtient la valeur de la propriété numberLastSuffix.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "NUMBER_LAST_SUFFIX", length = 255)
    public String getNumberLastSuffix() {
        return numberLastSuffix;
    }

    /**
     * Définit la valeur de la propriété numberLastSuffix.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberLastSuffix(String value) {
        this.numberLastSuffix = value;
    }

    /**
     * Obtient la valeur de la propriété address.
     * 
     * @return
     *     possible object is
     *     {@link AddressRef }
     *     
     */
    @ManyToOne(targetEntity = AddressRef.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "ADDRESS_STREET_SEGMENT_HJID")
    public AddressRef getAddress() {
        return address;
    }

    /**
     * Définit la valeur de la propriété address.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressRef }
     *     
     */
    public void setAddress(AddressRef value) {
        this.address = value;
    }

    @ManyToOne(targetEntity = Reference.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "STREET_STREET_SEGMENT_HJID")
    public Reference getStreet() {
        if (null == street){
            street = new Reference();
        }
        return street;
    }

    public void setStreet(Reference street) {
        this.street = street;
    }

}
