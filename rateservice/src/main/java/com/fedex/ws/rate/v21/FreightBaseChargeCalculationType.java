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
 * <p>Java class for FreightBaseChargeCalculationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FreightBaseChargeCalculationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="BEYOND"/&gt;
 *     &lt;enumeration value="LINE_ITEMS"/&gt;
 *     &lt;enumeration value="UNIT_PRICING"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FreightBaseChargeCalculationType")
@XmlEnum
public enum FreightBaseChargeCalculationType {

    BEYOND,
    LINE_ITEMS,
    UNIT_PRICING;

    public String value() {
        return name();
    }

    public static FreightBaseChargeCalculationType fromValue(String v) {
        return valueOf(v);
    }

}
