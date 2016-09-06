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


/**
 * Specifies the characteristics of the containing RequestedShipment that define its participation in a consolidation.
 * 
 * <p>Java class for ShipmentConsolidationDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShipmentConsolidationDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RelationshipTimestamp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Type" type="{http://fedex.com/ws/rate/v21}ConsolidationType" minOccurs="0"/&gt;
 *         &lt;element name="Role" type="{http://fedex.com/ws/rate/v21}ConsolidationShipmentRoleType" minOccurs="0"/&gt;
 *         &lt;element name="AssociatedTrackingIds" type="{http://fedex.com/ws/rate/v21}AssociatedTrackingId" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="SpecialServicesRequested" type="{http://fedex.com/ws/rate/v21}ConsolidationSpecialServicesRequested" minOccurs="0"/&gt;
 *         &lt;element name="InternationalDistributionDetail" type="{http://fedex.com/ws/rate/v21}ShipmentInternationalDistributionDetail" minOccurs="0"/&gt;
 *         &lt;element name="TransborderDistributionDetail" type="{http://fedex.com/ws/rate/v21}ShipmentTransborderDistributionDetail" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentConsolidationDetail", propOrder = {
    "relationshipTimestamp",
    "type",
    "role",
    "associatedTrackingIds",
    "specialServicesRequested",
    "internationalDistributionDetail",
    "transborderDistributionDetail"
})
public class ShipmentConsolidationDetail {

    @XmlElement(name = "RelationshipTimestamp")
    protected String relationshipTimestamp;
    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected ConsolidationType type;
    @XmlElement(name = "Role")
    @XmlSchemaType(name = "string")
    protected ConsolidationShipmentRoleType role;
    @XmlElement(name = "AssociatedTrackingIds")
    protected List<AssociatedTrackingId> associatedTrackingIds;
    @XmlElement(name = "SpecialServicesRequested")
    protected ConsolidationSpecialServicesRequested specialServicesRequested;
    @XmlElement(name = "InternationalDistributionDetail")
    protected ShipmentInternationalDistributionDetail internationalDistributionDetail;
    @XmlElement(name = "TransborderDistributionDetail")
    protected ShipmentTransborderDistributionDetail transborderDistributionDetail;

    /**
     * Gets the value of the relationshipTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationshipTimestamp() {
        return relationshipTimestamp;
    }

    /**
     * Sets the value of the relationshipTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationshipTimestamp(String value) {
        this.relationshipTimestamp = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ConsolidationType }
     *     
     */
    public ConsolidationType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsolidationType }
     *     
     */
    public void setType(ConsolidationType value) {
        this.type = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link ConsolidationShipmentRoleType }
     *     
     */
    public ConsolidationShipmentRoleType getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsolidationShipmentRoleType }
     *     
     */
    public void setRole(ConsolidationShipmentRoleType value) {
        this.role = value;
    }

    /**
     * Gets the value of the associatedTrackingIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the associatedTrackingIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssociatedTrackingIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssociatedTrackingId }
     * 
     * 
     */
    public List<AssociatedTrackingId> getAssociatedTrackingIds() {
        if (associatedTrackingIds == null) {
            associatedTrackingIds = new ArrayList<AssociatedTrackingId>();
        }
        return this.associatedTrackingIds;
    }

    /**
     * Gets the value of the specialServicesRequested property.
     * 
     * @return
     *     possible object is
     *     {@link ConsolidationSpecialServicesRequested }
     *     
     */
    public ConsolidationSpecialServicesRequested getSpecialServicesRequested() {
        return specialServicesRequested;
    }

    /**
     * Sets the value of the specialServicesRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsolidationSpecialServicesRequested }
     *     
     */
    public void setSpecialServicesRequested(ConsolidationSpecialServicesRequested value) {
        this.specialServicesRequested = value;
    }

    /**
     * Gets the value of the internationalDistributionDetail property.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentInternationalDistributionDetail }
     *     
     */
    public ShipmentInternationalDistributionDetail getInternationalDistributionDetail() {
        return internationalDistributionDetail;
    }

    /**
     * Sets the value of the internationalDistributionDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentInternationalDistributionDetail }
     *     
     */
    public void setInternationalDistributionDetail(ShipmentInternationalDistributionDetail value) {
        this.internationalDistributionDetail = value;
    }

    /**
     * Gets the value of the transborderDistributionDetail property.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentTransborderDistributionDetail }
     *     
     */
    public ShipmentTransborderDistributionDetail getTransborderDistributionDetail() {
        return transborderDistributionDetail;
    }

    /**
     * Sets the value of the transborderDistributionDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentTransborderDistributionDetail }
     *     
     */
    public void setTransborderDistributionDetail(ShipmentTransborderDistributionDetail value) {
        this.transborderDistributionDetail = value;
    }

}
