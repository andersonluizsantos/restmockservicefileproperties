package br.com.anderson.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import java.io.StringReader;
import java.io.StringWriter;

/**
 * Classe utilitária para manipular XMLs
 * @author tarcisio.de.l.amorim
 *
 */
public class XmlUtils {

	private XmlUtils(){}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String getXMLValue(Object param) {
		if (param == null) {
			return "nulo";
		}
		
		if (String.class.isInstance(param)) {
			return String.class.cast(param);
		}
		
		if (Number.class.isInstance(param)) {
			return Number.class.cast(param).toString();
		}
		
		if (Boolean.class.isInstance(param)) {
			return Boolean.class.cast(param).toString();
		}
		
		try {
			
			JAXBContext jc = JAXBContext.newInstance(String.class, param.getClass());
			JAXBIntrospector introspector = jc.createJAXBIntrospector();
			Marshaller marshaller = jc.createMarshaller();

			StringWriter sw = new StringWriter();

			if (null == introspector.getElementName(param)) {
				marshaller.marshal(new JAXBElement(new QName("root"), param.getClass(), param), sw);
			} else {
				marshaller.marshal(param, sw);
			}
			return sw.toString();
		} catch (Exception e) {
			return param.toString();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> T getObjectValue(String value, Class<T> className) {
		try {
			JAXBContext jc = JAXBContext.newInstance(className);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
	
			StringReader sr = new StringReader(value);
			
			return (T) unmarshaller.unmarshal(sr);
		} catch (Exception e) {
			e.printStackTrace(System.out);			
		}
		return null;
	}
	
	
	
}
