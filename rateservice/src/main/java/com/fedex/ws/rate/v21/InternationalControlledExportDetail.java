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
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for InternationalControlledExportDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InternationalControlledExportDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Type" type="{http://fedex.com/ws/rate/v21}InternationalControlledExportType" minOccurs="0"/&gt;
 *         &lt;element name="ForeignTradeZoneCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EntryNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LicenseOrPermitNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LicenseOrPermitExpirationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InternationalControlledExportDetail", propOrder = {
    "type",
    "foreignTradeZoneCode",
    "entryNumber",
    "licenseOrPermitNumber",
    "licenseOrPermitExpirationDate"
})
public class InternationalControlledExportDetail {

    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected InternationalControlledExportType type;
    @XmlElement(name = "ForeignTradeZoneCode")
    protected String foreignTradeZoneCode;
    @XmlElement(name = "EntryNumber")
    protected String entryNumber;
    @XmlElement(name = "LicenseOrPermitNumber")
    protected String licenseOrPermitNumber;
    @XmlElement(name = "LicenseOrPermitExpirationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar licenseOrPermitExpirationDate;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link InternationalControlledExportType }
     *     
     */
    public InternationalControlledExportType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link InternationalControlledExportType }
     *     
     */
    public void setType(InternationalControlledExportType value) {
        this.type = value;
    }

    /**
     * Gets the value of the foreignTradeZoneCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForeignTradeZoneCode() {
        return foreignTradeZoneCode;
    }

    /**
     * Sets the value of the foreignTradeZoneCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignTradeZoneCode(String value) {
        this.foreignTradeZoneCode = value;
    }

    /**
     * Gets the value of the entryNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntryNumber() {
        return entryNumber;
    }

    /**
     * Sets the value of the entryNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntryNumber(String value) {
        this.entryNumber = value;
    }

    /**
     * Gets the value of the licenseOrPermitNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseOrPermitNumber() {
        return licenseOrPermitNumber;
    }

    /**
     * Sets the value of the licenseOrPermitNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseOrPermitNumber(String value) {
        this.licenseOrPermitNumber = value;
    }

    /**
     * Gets the value of the licenseOrPermitExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLicenseOrPermitExpirationDate() {
        return licenseOrPermitExpirationDate;
    }

    /**
     * Sets the value of the licenseOrPermitExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLicenseOrPermitExpirationDate(XMLGregorianCalendar value) {
        this.licenseOrPermitExpirationDate = value;
    }

}