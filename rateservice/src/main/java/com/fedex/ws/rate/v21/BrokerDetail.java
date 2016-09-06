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
 * <p>Java class for BrokerDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BrokerDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Type" type="{http://fedex.com/ws/rate/v21}BrokerType" minOccurs="0"/&gt;
 *         &lt;element name="Broker" type="{http://fedex.com/ws/rate/v21}Party" minOccurs="0"/&gt;
 *         &lt;element name="BrokerageProcessingChargesPayment" type="{http://fedex.com/ws/rate/v21}Payment" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BrokerDetail", propOrder = {
    "type",
    "broker",
    "brokerageProcessingChargesPayment"
})
public class BrokerDetail {

    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected BrokerType type;
    @XmlElement(name = "Broker")
    protected Party broker;
    @XmlElement(name = "BrokerageProcessingChargesPayment")
    protected Payment brokerageProcessingChargesPayment;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link BrokerType }
     *     
     */
    public BrokerType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link BrokerType }
     *     
     */
    public void setType(BrokerType value) {
        this.type = value;
    }

    /**
     * Gets the value of the broker property.
     * 
     * @return
     *     possible object is
     *     {@link Party }
     *     
     */
    public Party getBroker() {
        return broker;
    }

    /**
     * Sets the value of the broker property.
     * 
     * @param value
     *     allowed object is
     *     {@link Party }
     *     
     */
    public void setBroker(Party value) {
        this.broker = value;
    }

    /**
     * Gets the value of the brokerageProcessingChargesPayment property.
     * 
     * @return
     *     possible object is
     *     {@link Payment }
     *     
     */
    public Payment getBrokerageProcessingChargesPayment() {
        return brokerageProcessingChargesPayment;
    }

    /**
     * Sets the value of the brokerageProcessingChargesPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Payment }
     *     
     */
    public void setBrokerageProcessingChargesPayment(Payment value) {
        this.brokerageProcessingChargesPayment = value;
    }

}
