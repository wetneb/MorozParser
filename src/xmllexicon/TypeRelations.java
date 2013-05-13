//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.13 at 05:21:45 PM CEST 
//


package xmllexicon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import pregroup.Comparator;
import pregroup.FreeType;


/**
 * <p>Java class for TypeRelations complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypeRelations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rel" type="{}TypeRel" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypeRelations", propOrder = {
    "rel"
})
public class TypeRelations implements Comparator<FreeType> {

    @XmlElement(required = true)
    protected List<TypeRel> rel;

    /**
     * Gets the value of the rel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypeRel }
     * 
     * 
     */
    public List<TypeRel> getRel() {
        if (rel == null) {
            rel = new ArrayList<TypeRel>();
        }
        return this.rel;
    }
    
    /// MODIFICATION (will be lost on recompilation of xmllexicon.xsd)
    public boolean lessThan(FreeType lhs, FreeType rhs)
    {
    	String a = lhs.toString(), b = rhs.toString();
    	if(a.equals(b))
    		return true;
    	
    	for(TypeRel r : getRel())
    	{
    		if(a.equals(r.smaller) && b.equals(r.greater))
    			return true;
    	}
    	
    	return false;
    }
}
