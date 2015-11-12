//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.07.15 at 02:21:20 PM CDT 
//

package cs544.exercise25_1.generated.customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="customerNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "name" })
@XmlRootElement(name = "customer")
public class Customer {

	@XmlValue
	protected String name;
	@XmlAttribute
	protected String customerNumber;

	public Customer() {
	}

	public Customer(String customerNumber, String name) {
		this.customerNumber = customerNumber;
		this.name = name;
	}

	/**
	 * Gets the value of the value property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 * @param name
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the value of the customerNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * Sets the value of the customerNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCustomerNumber(String value) {
		this.customerNumber = value;
	}

	public String toString() {
		return String.format("Customer Number: %s Name: %s", getCustomerNumber(), getName());
	}
}
