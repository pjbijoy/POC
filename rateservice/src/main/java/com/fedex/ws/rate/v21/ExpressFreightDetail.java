//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.31 at 03:48:00 PM CDT 
//


package com.fedex.ws.rate.v21;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExpressFreightDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExpressFreightDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PackingListEnclosed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ShippersLoadAndCount" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/&gt;
 *         &lt;element name="BookingConfirmationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReferenceLabelRequested" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="BeforeDeliveryContact" type="{http://fedex.com/ws/rate/v21}ExpressFreightDetailContact" minOccurs="0"/&gt;
 *         &lt;element name="UndeliverableContact" type="{http://fedex.com/ws/rate/v21}ExpressFreightDetailContact" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExpressFreightDetail", propOrder = {
    "packingListEnclosed",
    "shippersLoadAndCount",
    "bookingConfirmationNumber",
    "referenceLabelRequested",
    "beforeDeliveryContact",
    "undeliverableContact"
})
public class ExpressFreightDetail {

    @XmlElement(name = "PackingListEnclosed")
    protected Boolean packingListEnclosed;
    @XmlElement(name = "ShippersLoadAndCount")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger shippersLoadAndCount;
    @XmlElement(name = "BookingConfirmationNumber")
    protected String bookingConfirmationNumber;
    @XmlElement(name = "ReferenceLabelRequested")
    protected Boolean referenceLabelRequested;
    @XmlElement(name = "BeforeDeliveryContact")
    protected ExpressFreightDetailContact beforeDeliveryContact;
    @XmlElement(name = "UndeliverableContact")
    protected ExpressFreightDetailContact undeliverableContact;

    /**
     * Gets the value of the packingListEnclosed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPackingListEnclosed() {
        return packingListEnclosed;
    }

    /**
     * Sets the value of the packingListEnclosed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPackingListEnclosed(Boolean value) {
        this.packingListEnclosed = value;
    }

    /**
     * Gets the value of the shippersLoadAndCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getShippersLoadAndCount() {
        return shippersLoadAndCount;
    }

    /**
     * Sets the value of the shippersLoadAndCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setShippersLoadAndCount(BigInteger value) {
        this.shippersLoadAndCount = value;
    }

    /**
     * Gets the value of the bookingConfirmationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingConfirmationNumber() {
        return bookingConfirmationNumber;
    }

    /**
     * Sets the value of the bookingConfirmationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingConfirmationNumber(String value) {
        this.bookingConfirmationNumber = value;
    }

    /**
     * Gets the value of the referenceLabelRequested property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReferenceLabelRequested() {
        return referenceLabelRequested;
    }

    /**
     * Sets the value of the referenceLabelRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReferenceLabelRequested(Boolean value) {
        this.referenceLabelRequested = value;
    }

    /**
     * Gets the value of the beforeDeliveryContact property.
     * 
     * @return
     *     possible object is
     *     {@link ExpressFreightDetailContact }
     *     
     */
    public ExpressFreightDetailContact getBeforeDeliveryContact() {
        return beforeDeliveryContact;
    }

    /**
     * Sets the value of the beforeDeliveryContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressFreightDetailContact }
     *     
     */
    public void setBeforeDeliveryContact(ExpressFreightDetailContact value) {
        this.beforeDeliveryContact = value;
    }

    /**
     * Gets the value of the undeliverableContact property.
     * 
     * @return
     *     possible object is
     *     {@link ExpressFreightDetailContact }
     *     
     */
    public ExpressFreightDetailContact getUndeliverableContact() {
        return undeliverableContact;
    }

    /**
     * Sets the value of the undeliverableContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressFreightDetailContact }
     *     
     */
    public void setUndeliverableContact(ExpressFreightDetailContact value) {
        this.undeliverableContact = value;
    }

}
