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
 * <p>Java class for UploadDocumentIdProducer.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UploadDocumentIdProducer"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CUSTOMER"/&gt;
 *     &lt;enumeration value="FEDEX_CAFE"/&gt;
 *     &lt;enumeration value="FEDEX_CSHP"/&gt;
 *     &lt;enumeration value="FEDEX_FXRS"/&gt;
 *     &lt;enumeration value="FEDEX_GSMW"/&gt;
 *     &lt;enumeration value="FEDEX_GTM"/&gt;
 *     &lt;enumeration value="FEDEX_INET"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "UploadDocumentIdProducer")
@XmlEnum
public enum UploadDocumentIdProducer {

    CUSTOMER,
    FEDEX_CAFE,
    FEDEX_CSHP,
    FEDEX_FXRS,
    FEDEX_GSMW,
    FEDEX_GTM,
    FEDEX_INET;

    public String value() {
        return name();
    }

    public static UploadDocumentIdProducer fromValue(String v) {
        return valueOf(v);
    }

}