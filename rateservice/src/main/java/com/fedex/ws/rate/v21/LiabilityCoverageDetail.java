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
 * <p>Java class for LiabilityCoverageDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LiabilityCoverageDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CoverageType" type="{http://fedex.com/ws/rate/v21}LiabilityCoverageType" minOccurs="0"/&gt;
 *         &lt;element name="CoverageAmount" type="{http://fedex.com/ws/rate/v21}Money" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LiabilityCoverageDetail", propOrder = {
    "coverageType",
    "coverageAmount"
})
public class LiabilityCoverageDetail {

    @XmlElement(name = "CoverageType")
    @XmlSchemaType(name = "string")
    protected LiabilityCoverageType coverageType;
    @XmlElement(name = "CoverageAmount")
    protected Money coverageAmount;

    /**
     * Gets the value of the coverageType property.
     * 
     * @return
     *     possible object is
     *     {@link LiabilityCoverageType }
     *     
     */
    public LiabilityCoverageType getCoverageType() {
        return coverageType;
    }

    /**
     * Sets the value of the coverageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LiabilityCoverageType }
     *     
     */
    public void setCoverageType(LiabilityCoverageType value) {
        this.coverageType = value;
    }

    /**
     * Gets the value of the coverageAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getCoverageAmount() {
        return coverageAmount;
    }

    /**
     * Sets the value of the coverageAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setCoverageAmount(Money value) {
        this.coverageAmount = value;
    }

}
