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
 * <p>Java class for ExpressRegionCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExpressRegionCode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="APAC"/&gt;
 *     &lt;enumeration value="CA"/&gt;
 *     &lt;enumeration value="EMEA"/&gt;
 *     &lt;enumeration value="LAC"/&gt;
 *     &lt;enumeration value="US"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ExpressRegionCode")
@XmlEnum
public enum ExpressRegionCode {

    APAC,
    CA,
    EMEA,
    LAC,
    US;

    public String value() {
        return name();
    }

    public static ExpressRegionCode fromValue(String v) {
        return valueOf(v);
    }

}