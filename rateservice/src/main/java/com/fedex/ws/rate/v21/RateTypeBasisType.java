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
 * <p>Java class for RateTypeBasisType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RateTypeBasisType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ACCOUNT"/&gt;
 *     &lt;enumeration value="ACTUAL"/&gt;
 *     &lt;enumeration value="CURRENT"/&gt;
 *     &lt;enumeration value="CUSTOM"/&gt;
 *     &lt;enumeration value="LIST"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RateTypeBasisType")
@XmlEnum
public enum RateTypeBasisType {

    ACCOUNT,
    ACTUAL,
    CURRENT,
    CUSTOM,
    LIST;

    public String value() {
        return name();
    }

    public static RateTypeBasisType fromValue(String v) {
        return valueOf(v);
    }

}
