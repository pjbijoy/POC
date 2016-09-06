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
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the attributes of a shipment related to its role in a transborder distribution (consolidation).
 * 
 * <p>Java class for ShipmentTransborderDistributionDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShipmentTransborderDistributionDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SpecialServicesRequested" type="{http://fedex.com/ws/rate/v21}TransborderDistributionSpecialServicesRequested" minOccurs="0"/&gt;
 *         &lt;element name="SummaryDetail" type="{http://fedex.com/ws/rate/v21}TransborderDistributionSummaryDetail" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentTransborderDistributionDetail", propOrder = {
    "specialServicesRequested",
    "summaryDetail"
})
public class ShipmentTransborderDistributionDetail {

    @XmlElement(name = "SpecialServicesRequested")
    protected TransborderDistributionSpecialServicesRequested specialServicesRequested;
    @XmlElement(name = "SummaryDetail")
    protected TransborderDistributionSummaryDetail summaryDetail;

    /**
     * Gets the value of the specialServicesRequested property.
     * 
     * @return
     *     possible object is
     *     {@link TransborderDistributionSpecialServicesRequested }
     *     
     */
    public TransborderDistributionSpecialServicesRequested getSpecialServicesRequested() {
        return specialServicesRequested;
    }

    /**
     * Sets the value of the specialServicesRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransborderDistributionSpecialServicesRequested }
     *     
     */
    public void setSpecialServicesRequested(TransborderDistributionSpecialServicesRequested value) {
        this.specialServicesRequested = value;
    }

    /**
     * Gets the value of the summaryDetail property.
     * 
     * @return
     *     possible object is
     *     {@link TransborderDistributionSummaryDetail }
     *     
     */
    public TransborderDistributionSummaryDetail getSummaryDetail() {
        return summaryDetail;
    }

    /**
     * Sets the value of the summaryDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransborderDistributionSummaryDetail }
     *     
     */
    public void setSummaryDetail(TransborderDistributionSummaryDetail value) {
        this.summaryDetail = value;
    }

}
