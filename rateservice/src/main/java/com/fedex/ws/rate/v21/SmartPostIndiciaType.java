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
 * <p>Java class for SmartPostIndiciaType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SmartPostIndiciaType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="MEDIA_MAIL"/&gt;
 *     &lt;enumeration value="PARCEL_RETURN"/&gt;
 *     &lt;enumeration value="PARCEL_SELECT"/&gt;
 *     &lt;enumeration value="PRESORTED_BOUND_PRINTED_MATTER"/&gt;
 *     &lt;enumeration value="PRESORTED_STANDARD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SmartPostIndiciaType")
@XmlEnum
public enum SmartPostIndiciaType {

    MEDIA_MAIL,
    PARCEL_RETURN,
    PARCEL_SELECT,
    PRESORTED_BOUND_PRINTED_MATTER,
    PRESORTED_STANDARD;

    public String value() {
        return name();
    }

    public static SmartPostIndiciaType fromValue(String v) {
        return valueOf(v);
    }

}