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
 * <p>Java class for RequestedShippingDocumentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RequestedShippingDocumentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CERTIFICATE_OF_ORIGIN"/&gt;
 *     &lt;enumeration value="COMMERCIAL_INVOICE"/&gt;
 *     &lt;enumeration value="CUSTOMER_SPECIFIED_LABELS"/&gt;
 *     &lt;enumeration value="CUSTOM_PACKAGE_DOCUMENT"/&gt;
 *     &lt;enumeration value="CUSTOM_SHIPMENT_DOCUMENT"/&gt;
 *     &lt;enumeration value="DANGEROUS_GOODS_SHIPPERS_DECLARATION"/&gt;
 *     &lt;enumeration value="EXPORT_DECLARATION"/&gt;
 *     &lt;enumeration value="FREIGHT_ADDRESS_LABEL"/&gt;
 *     &lt;enumeration value="GENERAL_AGENCY_AGREEMENT"/&gt;
 *     &lt;enumeration value="LABEL"/&gt;
 *     &lt;enumeration value="NAFTA_CERTIFICATE_OF_ORIGIN"/&gt;
 *     &lt;enumeration value="OP_900"/&gt;
 *     &lt;enumeration value="PRO_FORMA_INVOICE"/&gt;
 *     &lt;enumeration value="RETURN_INSTRUCTIONS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RequestedShippingDocumentType")
@XmlEnum
public enum RequestedShippingDocumentType {

    CERTIFICATE_OF_ORIGIN,
    COMMERCIAL_INVOICE,
    CUSTOMER_SPECIFIED_LABELS,
    CUSTOM_PACKAGE_DOCUMENT,
    CUSTOM_SHIPMENT_DOCUMENT,
    DANGEROUS_GOODS_SHIPPERS_DECLARATION,
    EXPORT_DECLARATION,
    FREIGHT_ADDRESS_LABEL,
    GENERAL_AGENCY_AGREEMENT,
    LABEL,
    NAFTA_CERTIFICATE_OF_ORIGIN,
    OP_900,
    PRO_FORMA_INVOICE,
    RETURN_INSTRUCTIONS;

    public String value() {
        return name();
    }

    public static RequestedShippingDocumentType fromValue(String v) {
        return valueOf(v);
    }

}
