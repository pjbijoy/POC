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
 * <p>Java class for TransactionDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CustomerTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Localization" type="{http://fedex.com/ws/rate/v21}Localization" minOccurs="0"/&gt;
 *         &lt;element name="InternalTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Tracing" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="SourceFormat" type="{http://fedex.com/ws/rate/v21}TransactionSourceFormat" minOccurs="0"/&gt;
 *         &lt;element name="Environment" type="{http://fedex.com/ws/rate/v21}WebServiceEnvironment" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionDetail", propOrder = {
    "customerTransactionId",
    "localization",
    "internalTransactionId",
    "tracing",
    "sourceFormat",
    "environment"
})
public class TransactionDetail {

    @XmlElement(name = "CustomerTransactionId")
    protected String customerTransactionId;
    @XmlElement(name = "Localization")
    protected Localization localization;
    @XmlElement(name = "InternalTransactionId")
    protected String internalTransactionId;
    @XmlElement(name = "Tracing")
    protected Boolean tracing;
    @XmlElement(name = "SourceFormat")
    @XmlSchemaType(name = "string")
    protected TransactionSourceFormat sourceFormat;
    @XmlElement(name = "Environment")
    @XmlSchemaType(name = "string")
    protected WebServiceEnvironment environment;

    /**
     * Gets the value of the customerTransactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerTransactionId() {
        return customerTransactionId;
    }

    /**
     * Sets the value of the customerTransactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerTransactionId(String value) {
        this.customerTransactionId = value;
    }

    /**
     * Gets the value of the localization property.
     * 
     * @return
     *     possible object is
     *     {@link Localization }
     *     
     */
    public Localization getLocalization() {
        return localization;
    }

    /**
     * Sets the value of the localization property.
     * 
     * @param value
     *     allowed object is
     *     {@link Localization }
     *     
     */
    public void setLocalization(Localization value) {
        this.localization = value;
    }

    /**
     * Gets the value of the internalTransactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalTransactionId() {
        return internalTransactionId;
    }

    /**
     * Sets the value of the internalTransactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalTransactionId(String value) {
        this.internalTransactionId = value;
    }

    /**
     * Gets the value of the tracing property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTracing() {
        return tracing;
    }

    /**
     * Sets the value of the tracing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTracing(Boolean value) {
        this.tracing = value;
    }

    /**
     * Gets the value of the sourceFormat property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionSourceFormat }
     *     
     */
    public TransactionSourceFormat getSourceFormat() {
        return sourceFormat;
    }

    /**
     * Sets the value of the sourceFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionSourceFormat }
     *     
     */
    public void setSourceFormat(TransactionSourceFormat value) {
        this.sourceFormat = value;
    }

    /**
     * Gets the value of the environment property.
     * 
     * @return
     *     possible object is
     *     {@link WebServiceEnvironment }
     *     
     */
    public WebServiceEnvironment getEnvironment() {
        return environment;
    }

    /**
     * Sets the value of the environment property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebServiceEnvironment }
     *     
     */
    public void setEnvironment(WebServiceEnvironment value) {
        this.environment = value;
    }

}
