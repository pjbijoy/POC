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
 * <p>Java class for CreditCardSettlementScheduleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CreditCardSettlementScheduleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SETTLE_IMMEDIATELY"/&gt;
 *     &lt;enumeration value="SETTLE_NEXT_DAY"/&gt;
 *     &lt;enumeration value="SETTLE_ON_DELIVERY"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CreditCardSettlementScheduleType")
@XmlEnum
public enum CreditCardSettlementScheduleType {

    SETTLE_IMMEDIATELY,
    SETTLE_NEXT_DAY,
    SETTLE_ON_DELIVERY;

    public String value() {
        return name();
    }

    public static CreditCardSettlementScheduleType fromValue(String v) {
        return valueOf(v);
    }

}
