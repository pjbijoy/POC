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
 * Identifies a relationship from one tracked entity to another.
 * 
 * <p>Java class for AssociatedTrackingId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssociatedTrackingId"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Type" type="{http://fedex.com/ws/rate/v21}AssociatedTrackingIdType" minOccurs="0"/&gt;
 *         &lt;element name="TrackingId" type="{http://fedex.com/ws/rate/v21}TrackingId" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssociatedTrackingId", propOrder = {
    "type",
    "trackingId"
})
public class AssociatedTrackingId {

    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected AssociatedTrackingIdType type;
    @XmlElement(name = "TrackingId")
    protected TrackingId trackingId;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link AssociatedTrackingIdType }
     *     
     */
    public AssociatedTrackingIdType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssociatedTrackingIdType }
     *     
     */
    public void setType(AssociatedTrackingIdType value) {
        this.type = value;
    }

    /**
     * Gets the value of the trackingId property.
     * 
     * @return
     *     possible object is
     *     {@link TrackingId }
     *     
     */
    public TrackingId getTrackingId() {
        return trackingId;
    }

    /**
     * Sets the value of the trackingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackingId }
     *     
     */
    public void setTrackingId(TrackingId value) {
        this.trackingId = value;
    }

}