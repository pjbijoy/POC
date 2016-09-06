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
 * <p>Java class for AdditionalLabelsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdditionalLabelsType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="BROKER"/&gt;
 *     &lt;enumeration value="CONSIGNEE"/&gt;
 *     &lt;enumeration value="CUSTOMS"/&gt;
 *     &lt;enumeration value="DESTINATION"/&gt;
 *     &lt;enumeration value="DESTINATION_CONTROL_STATEMENT"/&gt;
 *     &lt;enumeration value="FREIGHT_REFERENCE"/&gt;
 *     &lt;enumeration value="MANIFEST"/&gt;
 *     &lt;enumeration value="ORIGIN"/&gt;
 *     &lt;enumeration value="RECIPIENT"/&gt;
 *     &lt;enumeration value="SECOND_ADDRESS"/&gt;
 *     &lt;enumeration value="SHIPPER"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AdditionalLabelsType")
@XmlEnum
public enum AdditionalLabelsType {

    BROKER,
    CONSIGNEE,
    CUSTOMS,
    DESTINATION,
    DESTINATION_CONTROL_STATEMENT,
    FREIGHT_REFERENCE,
    MANIFEST,
    ORIGIN,
    RECIPIENT,
    SECOND_ADDRESS,
    SHIPPER;

    public String value() {
        return name();
    }

    public static AdditionalLabelsType fromValue(String v) {
        return valueOf(v);
    }

}