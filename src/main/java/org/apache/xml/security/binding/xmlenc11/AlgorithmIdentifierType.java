/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2017.07.31 at 11:10:09 AM IST
//


package org.apache.xml.security.binding.xmlenc11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AlgorithmIdentifierType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AlgorithmIdentifierType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Parameters" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlgorithmIdentifierType", namespace = "http://www.w3.org/2009/xmlenc11#", propOrder = {
    "parameters"
})
@XmlSeeAlso({
    MGFType.class,
    PRFAlgorithmIdentifierType.class
})
public class AlgorithmIdentifierType {

    @XmlElement(name = "Parameters", namespace = "http://www.w3.org/2009/xmlenc11#")
    protected Object parameters;
    @XmlAttribute(name = "Algorithm", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String algorithm;

    /**
     * Gets the value of the parameters property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getParameters() {
        return parameters;
    }

    /**
     * Sets the value of the parameters property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setParameters(Object value) {
        this.parameters = value;
    }

    /**
     * Gets the value of the algorithm property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Sets the value of the algorithm property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAlgorithm(String value) {
        this.algorithm = value;
    }

}
