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
 * <p>Java class for VariableHandlingCharges complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VariableHandlingCharges"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="VariableHandlingCharge" type="{http://fedex.com/ws/rate/v21}Money" minOccurs="0"/&gt;
 *         &lt;element name="FixedVariableHandlingCharge" type="{http://fedex.com/ws/rate/v21}Money" minOccurs="0"/&gt;
 *         &lt;element name="PercentVariableHandlingCharge" type="{http://fedex.com/ws/rate/v21}Money" minOccurs="0"/&gt;
 *         &lt;element name="TotalCustomerCharge" type="{http://fedex.com/ws/rate/v21}Money" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VariableHandlingCharges", propOrder = {
    "variableHandlingCharge",
    "fixedVariableHandlingCharge",
    "percentVariableHandlingCharge",
    "totalCustomerCharge"
})
public class VariableHandlingCharges {

    @XmlElement(name = "VariableHandlingCharge")
    protected Money variableHandlingCharge;
    @XmlElement(name = "FixedVariableHandlingCharge")
    protected Money fixedVariableHandlingCharge;
    @XmlElement(name = "PercentVariableHandlingCharge")
    protected Money percentVariableHandlingCharge;
    @XmlElement(name = "TotalCustomerCharge")
    protected Money totalCustomerCharge;

    /**
     * Gets the value of the variableHandlingCharge property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getVariableHandlingCharge() {
        return variableHandlingCharge;
    }

    /**
     * Sets the value of the variableHandlingCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setVariableHandlingCharge(Money value) {
        this.variableHandlingCharge = value;
    }

    /**
     * Gets the value of the fixedVariableHandlingCharge property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getFixedVariableHandlingCharge() {
        return fixedVariableHandlingCharge;
    }

    /**
     * Sets the value of the fixedVariableHandlingCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setFixedVariableHandlingCharge(Money value) {
        this.fixedVariableHandlingCharge = value;
    }

    /**
     * Gets the value of the percentVariableHandlingCharge property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getPercentVariableHandlingCharge() {
        return percentVariableHandlingCharge;
    }

    /**
     * Sets the value of the percentVariableHandlingCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setPercentVariableHandlingCharge(Money value) {
        this.percentVariableHandlingCharge = value;
    }

    /**
     * Gets the value of the totalCustomerCharge property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getTotalCustomerCharge() {
        return totalCustomerCharge;
    }

    /**
     * Sets the value of the totalCustomerCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setTotalCustomerCharge(Money value) {
        this.totalCustomerCharge = value;
    }

}
