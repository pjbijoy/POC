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
 * <p>Java class for UploadDocumentReferenceDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UploadDocumentReferenceDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LineNumber" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/&gt;
 *         &lt;element name="CustomerReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DocumentProducer" type="{http://fedex.com/ws/rate/v21}UploadDocumentProducerType" minOccurs="0"/&gt;
 *         &lt;element name="DocumentType" type="{http://fedex.com/ws/rate/v21}UploadDocumentType" minOccurs="0"/&gt;
 *         &lt;element name="DocumentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DocumentIdProducer" type="{http://fedex.com/ws/rate/v21}UploadDocumentIdProducer" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadDocumentReferenceDetail", propOrder = {
    "lineNumber",
    "customerReference",
    "description",
    "documentProducer",
    "documentType",
    "documentId",
    "documentIdProducer"
})
public class UploadDocumentReferenceDetail {

    @XmlElement(name = "LineNumber")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger lineNumber;
    @XmlElement(name = "CustomerReference")
    protected String customerReference;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "DocumentProducer")
    @XmlSchemaType(name = "string")
    protected UploadDocumentProducerType documentProducer;
    @XmlElement(name = "DocumentType")
    @XmlSchemaType(name = "string")
    protected UploadDocumentType documentType;
    @XmlElement(name = "DocumentId")
    protected String documentId;
    @XmlElement(name = "DocumentIdProducer")
    @XmlSchemaType(name = "string")
    protected UploadDocumentIdProducer documentIdProducer;

    /**
     * Gets the value of the lineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLineNumber() {
        return lineNumber;
    }

    /**
     * Sets the value of the lineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLineNumber(BigInteger value) {
        this.lineNumber = value;
    }

    /**
     * Gets the value of the customerReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerReference() {
        return customerReference;
    }

    /**
     * Sets the value of the customerReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerReference(String value) {
        this.customerReference = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the documentProducer property.
     * 
     * @return
     *     possible object is
     *     {@link UploadDocumentProducerType }
     *     
     */
    public UploadDocumentProducerType getDocumentProducer() {
        return documentProducer;
    }

    /**
     * Sets the value of the documentProducer property.
     * 
     * @param value
     *     allowed object is
     *     {@link UploadDocumentProducerType }
     *     
     */
    public void setDocumentProducer(UploadDocumentProducerType value) {
        this.documentProducer = value;
    }

    /**
     * Gets the value of the documentType property.
     * 
     * @return
     *     possible object is
     *     {@link UploadDocumentType }
     *     
     */
    public UploadDocumentType getDocumentType() {
        return documentType;
    }

    /**
     * Sets the value of the documentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link UploadDocumentType }
     *     
     */
    public void setDocumentType(UploadDocumentType value) {
        this.documentType = value;
    }

    /**
     * Gets the value of the documentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * Sets the value of the documentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentId(String value) {
        this.documentId = value;
    }

    /**
     * Gets the value of the documentIdProducer property.
     * 
     * @return
     *     possible object is
     *     {@link UploadDocumentIdProducer }
     *     
     */
    public UploadDocumentIdProducer getDocumentIdProducer() {
        return documentIdProducer;
    }

    /**
     * Sets the value of the documentIdProducer property.
     * 
     * @param value
     *     allowed object is
     *     {@link UploadDocumentIdProducer }
     *     
     */
    public void setDocumentIdProducer(UploadDocumentIdProducer value) {
        this.documentIdProducer = value;
    }

}
