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
 * <p>Java class for NotificationDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotificationDetail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NotificationType" type="{http://fedex.com/ws/rate/v21}NotificationType" minOccurs="0"/&gt;
 *         &lt;element name="EmailDetail" type="{http://fedex.com/ws/rate/v21}EMailDetail" minOccurs="0"/&gt;
 *         &lt;element name="Localization" type="{http://fedex.com/ws/rate/v21}Localization" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotificationDetail", propOrder = {
    "notificationType",
    "emailDetail",
    "localization"
})
public class NotificationDetail {

    @XmlElement(name = "NotificationType")
    @XmlSchemaType(name = "string")
    protected NotificationType notificationType;
    @XmlElement(name = "EmailDetail")
    protected EMailDetail emailDetail;
    @XmlElement(name = "Localization")
    protected Localization localization;

    /**
     * Gets the value of the notificationType property.
     * 
     * @return
     *     possible object is
     *     {@link NotificationType }
     *     
     */
    public NotificationType getNotificationType() {
        return notificationType;
    }

    /**
     * Sets the value of the notificationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationType }
     *     
     */
    public void setNotificationType(NotificationType value) {
        this.notificationType = value;
    }

    /**
     * Gets the value of the emailDetail property.
     * 
     * @return
     *     possible object is
     *     {@link EMailDetail }
     *     
     */
    public EMailDetail getEmailDetail() {
        return emailDetail;
    }

    /**
     * Sets the value of the emailDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link EMailDetail }
     *     
     */
    public void setEmailDetail(EMailDetail value) {
        this.emailDetail = value;
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

}
