//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.31 at 03:48:00 PM CDT 
//


package com.fedex.ws.rate.v21;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequiredShippingDocumentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RequiredShippingDocumentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CANADIAN_B13A"/&gt;
 *     &lt;enumeration value="CERTIFICATE_OF_ORIGIN"/&gt;
 *     &lt;enumeration value="COMMERCIAL_INVOICE"/&gt;
 *     &lt;enumeration value="INTERNATIONAL_AIRWAY_BILL"/&gt;
 *     &lt;enumeration value="MAIL_SERVICE_AIRWAY_BILL"/&gt;
 *     &lt;enumeration value="SHIPPERS_EXPORT_DECLARATION"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RequiredShippingDocumentType")
@XmlEnum
public enum RequiredShippingDocumentType {

    @XmlEnumValue("CANADIAN_B13A")
    CANADIAN_B_13_A("CANADIAN_B13A"),
    CERTIFICATE_OF_ORIGIN("CERTIFICATE_OF_ORIGIN"),
    COMMERCIAL_INVOICE("COMMERCIAL_INVOICE"),
    INTERNATIONAL_AIRWAY_BILL("INTERNATIONAL_AIRWAY_BILL"),
    MAIL_SERVICE_AIRWAY_BILL("MAIL_SERVICE_AIRWAY_BILL"),
    SHIPPERS_EXPORT_DECLARATION("SHIPPERS_EXPORT_DECLARATION");
    private final String value;

    RequiredShippingDocumentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RequiredShippingDocumentType fromValue(String v) {
        for (RequiredShippingDocumentType c: RequiredShippingDocumentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
