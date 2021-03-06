//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.26 at 01:04:00 PM CEST 
//


package xmllexicon;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Lexicon_QNAME = new QName("", "lexicon");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TypeRelations }
     * 
     */
    public TypeRelations createTypeRelations() {
        return new TypeRelations();
    }

    /**
     * Create an instance of {@link TypeRel }
     * 
     */
    public TypeRel createTypeRel() {
        return new TypeRel();
    }

    /**
     * Create an instance of {@link EntryType }
     * 
     */
    public EntryType createEntryType() {
        return new EntryType();
    }

    /**
     * Create an instance of {@link RawLexicon }
     * 
     */
    public RawLexicon createRawLexicon() {
        return new RawLexicon();
    }

    /**
     * Create an instance of {@link Entries }
     * 
     */
    public Entries createEntries() {
        return new Entries();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RawLexicon }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "lexicon")
    public JAXBElement<RawLexicon> createLexicon(RawLexicon value) {
        return new JAXBElement<RawLexicon>(_Lexicon_QNAME, RawLexicon.class, null, value);
    }

}
