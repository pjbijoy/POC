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
 * <p>Java class for NetExplosiveClassificationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NetExplosiveClassificationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NET_EXPLOSIVE_CONTENT"/&gt;
 *     &lt;enumeration value="NET_EXPLOSIVE_MASS"/&gt;
 *     &lt;enumeration value="NET_EXPLOSIVE_QUANTITY"/&gt;
 *     &lt;enumeration value="NET_EXPLOSIVE_WEIGHT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "NetExplosiveClassificationType")
@XmlEnum
public enum NetExplosiveClassificationType {

    NET_EXPLOSIVE_CONTENT,
    NET_EXPLOSIVE_MASS,
    NET_EXPLOSIVE_QUANTITY,
    NET_EXPLOSIVE_WEIGHT;

    public String value() {
        return name();
    }

    public static NetExplosiveClassificationType fromValue(String v) {
        return valueOf(v);
    }

}
