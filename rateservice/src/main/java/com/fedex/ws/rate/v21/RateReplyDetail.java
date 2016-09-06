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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RateReplyDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RateReplyDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServiceType" type="{http://fedex.com/ws/rate/v21}ServiceType" minOccurs="0"/&gt;
 *         &lt;element name="PackagingType" type="{http://fedex.com/ws/rate/v21}PackagingType" minOccurs="0"/&gt;
 *         &lt;element name="AppliedOptions" type="{http://fedex.com/ws/rate/v21}ServiceOptionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AppliedSubOptions" type="{http://fedex.com/ws/rate/v21}ServiceSubOptionDetail" minOccurs="0"/&gt;
 *         &lt;element name="DeliveryStation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DeliveryDayOfWeek" type="{http://fedex.com/ws/rate/v21}DayOfWeekType" minOccurs="0"/&gt;
 *         &lt;element name="DeliveryTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="CommitDetails" type="{http://fedex.com/ws/rate/v21}CommitDetail" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="DestinationAirportId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IneligibleForMoneyBackGuarantee" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="OriginServiceArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DestinationServiceArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TransitTime" type="{http://fedex.com/ws/rate/v21}TransitTimeType" minOccurs="0"/&gt;
 *         &lt;element name="MaximumTransitTime" type="{http://fedex.com/ws/rate/v21}TransitTimeType" minOccurs="0"/&gt;
 *         &lt;element name="SignatureOption" type="{http://fedex.com/ws/rate/v21}SignatureOptionType" minOccurs="0"/&gt;
 *         &lt;element name="ActualRateType" type="{http://fedex.com/ws/rate/v21}ReturnedRateType" minOccurs="0"/&gt;
 *         &lt;element name="RatedShipmentDetails" type="{http://fedex.com/ws/rate/v21}RatedShipmentDetail" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RateReplyDetail", propOrder = {
    "serviceType",
    "packagingType",
    "appliedOptions",
    "appliedSubOptions",
    "deliveryStation",
    "deliveryDayOfWeek",
    "deliveryTimestamp",
    "commitDetails",
    "destinationAirportId",
    "ineligibleForMoneyBackGuarantee",
    "originServiceArea",
    "destinationServiceArea",
    "transitTime",
    "maximumTransitTime",
    "signatureOption",
    "actualRateType",
    "ratedShipmentDetails"
})
public class RateReplyDetail {

    @XmlElement(name = "ServiceType")
    @XmlSchemaType(name = "string")
    protected ServiceType serviceType;
    @XmlElement(name = "PackagingType")
    @XmlSchemaType(name = "string")
    protected PackagingType packagingType;
    @XmlElement(name = "AppliedOptions")
    @XmlSchemaType(name = "string")
    protected List<ServiceOptionType> appliedOptions;
    @XmlElement(name = "AppliedSubOptions")
    protected ServiceSubOptionDetail appliedSubOptions;
    @XmlElement(name = "DeliveryStation")
    protected String deliveryStation;
    @XmlElement(name = "DeliveryDayOfWeek")
    @XmlSchemaType(name = "string")
    protected DayOfWeekType deliveryDayOfWeek;
    @XmlElement(name = "DeliveryTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deliveryTimestamp;
    @XmlElement(name = "CommitDetails")
    protected List<CommitDetail> commitDetails;
    @XmlElement(name = "DestinationAirportId")
    protected String destinationAirportId;
    @XmlElement(name = "IneligibleForMoneyBackGuarantee")
    protected Boolean ineligibleForMoneyBackGuarantee;
    @XmlElement(name = "OriginServiceArea")
    protected String originServiceArea;
    @XmlElement(name = "DestinationServiceArea")
    protected String destinationServiceArea;
    @XmlElement(name = "TransitTime")
    @XmlSchemaType(name = "string")
    protected TransitTimeType transitTime;
    @XmlElement(name = "MaximumTransitTime")
    @XmlSchemaType(name = "string")
    protected TransitTimeType maximumTransitTime;
    @XmlElement(name = "SignatureOption")
    @XmlSchemaType(name = "string")
    protected SignatureOptionType signatureOption;
    @XmlElement(name = "ActualRateType")
    @XmlSchemaType(name = "string")
    protected ReturnedRateType actualRateType;
    @XmlElement(name = "RatedShipmentDetails")
    protected List<RatedShipmentDetail> ratedShipmentDetails;

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceType }
     *     
     */
    public ServiceType getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceType }
     *     
     */
    public void setServiceType(ServiceType value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the packagingType property.
     * 
     * @return
     *     possible object is
     *     {@link PackagingType }
     *     
     */
    public PackagingType getPackagingType() {
        return packagingType;
    }

    /**
     * Sets the value of the packagingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PackagingType }
     *     
     */
    public void setPackagingType(PackagingType value) {
        this.packagingType = value;
    }

    /**
     * Gets the value of the appliedOptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appliedOptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppliedOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceOptionType }
     * 
     * 
     */
    public List<ServiceOptionType> getAppliedOptions() {
        if (appliedOptions == null) {
            appliedOptions = new ArrayList<ServiceOptionType>();
        }
        return this.appliedOptions;
    }

    /**
     * Gets the value of the appliedSubOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceSubOptionDetail }
     *     
     */
    public ServiceSubOptionDetail getAppliedSubOptions() {
        return appliedSubOptions;
    }

    /**
     * Sets the value of the appliedSubOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceSubOptionDetail }
     *     
     */
    public void setAppliedSubOptions(ServiceSubOptionDetail value) {
        this.appliedSubOptions = value;
    }

    /**
     * Gets the value of the deliveryStation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryStation() {
        return deliveryStation;
    }

    /**
     * Sets the value of the deliveryStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryStation(String value) {
        this.deliveryStation = value;
    }

    /**
     * Gets the value of the deliveryDayOfWeek property.
     * 
     * @return
     *     possible object is
     *     {@link DayOfWeekType }
     *     
     */
    public DayOfWeekType getDeliveryDayOfWeek() {
        return deliveryDayOfWeek;
    }

    /**
     * Sets the value of the deliveryDayOfWeek property.
     * 
     * @param value
     *     allowed object is
     *     {@link DayOfWeekType }
     *     
     */
    public void setDeliveryDayOfWeek(DayOfWeekType value) {
        this.deliveryDayOfWeek = value;
    }

    /**
     * Gets the value of the deliveryTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeliveryTimestamp() {
        return deliveryTimestamp;
    }

    /**
     * Sets the value of the deliveryTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeliveryTimestamp(XMLGregorianCalendar value) {
        this.deliveryTimestamp = value;
    }

    /**
     * Gets the value of the commitDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commitDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommitDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommitDetail }
     * 
     * 
     */
    public List<CommitDetail> getCommitDetails() {
        if (commitDetails == null) {
            commitDetails = new ArrayList<CommitDetail>();
        }
        return this.commitDetails;
    }

    /**
     * Gets the value of the destinationAirportId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationAirportId() {
        return destinationAirportId;
    }

    /**
     * Sets the value of the destinationAirportId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationAirportId(String value) {
        this.destinationAirportId = value;
    }

    /**
     * Gets the value of the ineligibleForMoneyBackGuarantee property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIneligibleForMoneyBackGuarantee() {
        return ineligibleForMoneyBackGuarantee;
    }

    /**
     * Sets the value of the ineligibleForMoneyBackGuarantee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIneligibleForMoneyBackGuarantee(Boolean value) {
        this.ineligibleForMoneyBackGuarantee = value;
    }

    /**
     * Gets the value of the originServiceArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginServiceArea() {
        return originServiceArea;
    }

    /**
     * Sets the value of the originServiceArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginServiceArea(String value) {
        this.originServiceArea = value;
    }

    /**
     * Gets the value of the destinationServiceArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationServiceArea() {
        return destinationServiceArea;
    }

    /**
     * Sets the value of the destinationServiceArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationServiceArea(String value) {
        this.destinationServiceArea = value;
    }

    /**
     * Gets the value of the transitTime property.
     * 
     * @return
     *     possible object is
     *     {@link TransitTimeType }
     *     
     */
    public TransitTimeType getTransitTime() {
        return transitTime;
    }

    /**
     * Sets the value of the transitTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransitTimeType }
     *     
     */
    public void setTransitTime(TransitTimeType value) {
        this.transitTime = value;
    }

    /**
     * Gets the value of the maximumTransitTime property.
     * 
     * @return
     *     possible object is
     *     {@link TransitTimeType }
     *     
     */
    public TransitTimeType getMaximumTransitTime() {
        return maximumTransitTime;
    }

    /**
     * Sets the value of the maximumTransitTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransitTimeType }
     *     
     */
    public void setMaximumTransitTime(TransitTimeType value) {
        this.maximumTransitTime = value;
    }

    /**
     * Gets the value of the signatureOption property.
     * 
     * @return
     *     possible object is
     *     {@link SignatureOptionType }
     *     
     */
    public SignatureOptionType getSignatureOption() {
        return signatureOption;
    }

    /**
     * Sets the value of the signatureOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureOptionType }
     *     
     */
    public void setSignatureOption(SignatureOptionType value) {
        this.signatureOption = value;
    }

    /**
     * Gets the value of the actualRateType property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnedRateType }
     *     
     */
    public ReturnedRateType getActualRateType() {
        return actualRateType;
    }

    /**
     * Sets the value of the actualRateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnedRateType }
     *     
     */
    public void setActualRateType(ReturnedRateType value) {
        this.actualRateType = value;
    }

    /**
     * Gets the value of the ratedShipmentDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ratedShipmentDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRatedShipmentDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RatedShipmentDetail }
     * 
     * 
     */
    public List<RatedShipmentDetail> getRatedShipmentDetails() {
        if (ratedShipmentDetails == null) {
            ratedShipmentDetails = new ArrayList<RatedShipmentDetail>();
        }
        return this.ratedShipmentDetails;
    }

}