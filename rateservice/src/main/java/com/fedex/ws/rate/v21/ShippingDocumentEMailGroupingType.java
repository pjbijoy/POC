//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.31 at 03:48:00 PM CDT 
//


package com.fedex.ws.rate.v21;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ShippingDocumentEMailGroupingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ShippingDocumentEMailGroupingType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="BY_RECIPIENT"/&gt;
 *     &lt;enumeration value="NONE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ShippingDocumentEMailGroupingType")
@XmlEnum
public enum ShippingDocumentEMailGroupingType {

    BY_RECIPIENT,
    NONE;

    public String value() {
        return name();
    }

    public static ShippingDocumentEMailGroupingType fromValue(String v) {
        return valueOf(v);
    }

}
