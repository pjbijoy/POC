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
 * <p>Java class for TaxesOrMiscellaneousChargeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaxesOrMiscellaneousChargeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="COMMISSIONS"/&gt;
 *     &lt;enumeration value="DISCOUNTS"/&gt;
 *     &lt;enumeration value="HANDLING_FEES"/&gt;
 *     &lt;enumeration value="OTHER"/&gt;
 *     &lt;enumeration value="ROYALTIES_AND_LICENSE_FEES"/&gt;
 *     &lt;enumeration value="TAXES"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TaxesOrMiscellaneousChargeType")
@XmlEnum
public enum TaxesOrMiscellaneousChargeType {

    COMMISSIONS,
    DISCOUNTS,
    HANDLING_FEES,
    OTHER,
    ROYALTIES_AND_LICENSE_FEES,
    TAXES;

    public String value() {
        return name();
    }

    public static TaxesOrMiscellaneousChargeType fromValue(String v) {
        return valueOf(v);
    }

}
