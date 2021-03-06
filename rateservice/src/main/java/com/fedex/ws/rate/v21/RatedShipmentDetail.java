//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.31 at 03:48:00 PM CDT 
//


package com.fedex.ws.rate.v21;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This class groups the shipment and package rating data for a specific rate type for use in a rating reply, which groups result data by rate type.
 * 
 * <p>Java class for RatedShipmentDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RatedShipmentDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EffectiveNetDiscount" type="{http://fedex.com/ws/rate/v21}Money" minOccurs="0"/&gt;
 *         &lt;element name="AdjustedCodCollectionAmount" type="{http://fedex.com/ws/rate/v21}Money" minOccurs="0"/&gt;
 *         &lt;element name="ShipmentRateDetail" type="{http://fedex.com/ws/rate/v21}ShipmentRateDetail" minOccurs="0"/&gt;
 *         &lt;element name="RatedPackages" type="{http://fedex.com/ws/rate/v21}RatedPackageDetail" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RatedShipmentDetail", propOrder = {
    "effectiveNetDiscount",
    "adjustedCodCollectionAmount",
    "shipmentRateDetail",
    "ratedPackages"
})
public class RatedShipmentDetail {

    @XmlElement(name = "EffectiveNetDiscount")
    protected Money effectiveNetDiscount;
    @XmlElement(name = "AdjustedCodCollectionAmount")
    protected Money adjustedCodCollectionAmount;
    @XmlElement(name = "ShipmentRateDetail")
    protected ShipmentRateDetail shipmentRateDetail;
    @XmlElement(name = "RatedPackages")
    protected List<RatedPackageDetail> ratedPackages;

    /**
     * Gets the value of the effectiveNetDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getEffectiveNetDiscount() {
        return effectiveNetDiscount;
    }

    /**
     * Sets the value of the effectiveNetDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setEffectiveNetDiscount(Money value) {
        this.effectiveNetDiscount = value;
    }

    /**
     * Gets the value of the adjustedCodCollectionAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getAdjustedCodCollectionAmount() {
        return adjustedCodCollectionAmount;
    }

    /**
     * Sets the value of the adjustedCodCollectionAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setAdjustedCodCollectionAmount(Money value) {
        this.adjustedCodCollectionAmount = value;
    }

    /**
     * Gets the value of the shipmentRateDetail property.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentRateDetail }
     *     
     */
    public ShipmentRateDetail getShipmentRateDetail() {
        return shipmentRateDetail;
    }

    /**
     * Sets the value of the shipmentRateDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentRateDetail }
     *     
     */
    public void setShipmentRateDetail(ShipmentRateDetail value) {
        this.shipmentRateDetail = value;
    }

    /**
     * Gets the value of the ratedPackages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ratedPackages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRatedPackages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RatedPackageDetail }
     * 
     * 
     */
    public List<RatedPackageDetail> getRatedPackages() {
        if (ratedPackages == null) {
            ratedPackages = new ArrayList<RatedPackageDetail>();
        }
        return this.ratedPackages;
    }

}
