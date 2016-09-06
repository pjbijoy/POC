//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.31 at 03:48:00 PM CDT 
//


package com.fedex.ws.rate.v21;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomerImageUsage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerImageUsage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Type" type="{http://fedex.com/ws/rate/v21}CustomerImageUsageType" minOccurs="0"/&gt;
 *         &lt;element name="Id" type="{http://fedex.com/ws/rate/v21}ImageId" minOccurs="0"/&gt;
 *         &lt;element name="InternalId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InternalImageType" type="{http://fedex.com/ws/rate/v21}InternalImageType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerImageUsage", propOrder = {
    "type",
    "id",
    "internalId",
    "internalImageType"
})
public class CustomerImageUsage {

    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected CustomerImageUsageType type;
    @XmlElement(name = "Id")
    @XmlSchemaType(name = "string")
    protected ImageId id;
    @XmlElement(name = "InternalId")
    protected String internalId;
    @XmlElement(name = "InternalImageType")
    @XmlSchemaType(name = "string")
    protected InternalImageType internalImageType;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerImageUsageType }
     *     
     */
    public CustomerImageUsageType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerImageUsageType }
     *     
     */
    public void setType(CustomerImageUsageType value) {
        this.type = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link ImageId }
     *     
     */
    public ImageId getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageId }
     *     
     */
    public void setId(ImageId value) {
        this.id = value;
    }

    /**
     * Gets the value of the internalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalId() {
        return internalId;
    }

    /**
     * Sets the value of the internalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalId(String value) {
        this.internalId = value;
    }

    /**
     * Gets the value of the internalImageType property.
     * 
     * @return
     *     possible object is
     *     {@link InternalImageType }
     *     
     */
    public InternalImageType getInternalImageType() {
        return internalImageType;
    }

    /**
     * Sets the value of the internalImageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link InternalImageType }
     *     
     */
    public void setInternalImageType(InternalImageType value) {
        this.internalImageType = value;
    }

}
