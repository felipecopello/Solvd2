package com.solvd.airport.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTask {
	private static final Logger LOGGER = LogManager.getLogger(DomTask.class);
	private static DocumentBuilder builder;

	public static void enteringDocument(String classToAccess) {
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new File("src/main/resources/data.xml"));
			doc.getDocumentElement().normalize();
			Element root = doc.getDocumentElement();
			;

			recursionDOM(root);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	private static void recursionDOM(Node element) {

		System.out.println(element.getNodeName());

		if (element.hasChildNodes()) {
			for (Node child = element.getFirstChild(); child != null; child = child.getNextSibling()) {
				recursionDOM(child);
			}
		} else {
			System.out.println(element.getTextContent());
		}

	}

	public static void printDom(String path) throws Exception {
		builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = builder.parse(new File("src/main/resources/data.xml"));
		doc.getDocumentElement().normalize();
		DOMSource dom = new DOMSource(doc);
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(dom, new StreamResult(System.out));
	}

	public static void updateDom(String attName, String attValue) throws ParserConfigurationException {
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new File("src/main/resources/data.xml"));
			doc.getDocumentElement().normalize();
			NodeList passengerList = doc.getElementsByTagName("passenger");
			Element firstPassenger = (Element) passengerList.item(0);
			firstPassenger.setAttribute(attName, attValue);

		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void creatingDomDocument() {
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document newDoc = builder.newDocument();
			Element root = newDoc.createElement("passengers");
			newDoc.appendChild(root);

			Element first = newDoc.createElement("passenger");
			root.appendChild(first);
			first.setAttribute("id", "102");

			Element name = newDoc.createElement("name");
			name.appendChild(newDoc.createTextNode("John Gutierrez"));
			Element age = newDoc.createElement("age");
			age.appendChild(newDoc.createTextNode("58"));
			Element email = newDoc.createElement("email");
			email.appendChild(newDoc.createTextNode("john@example.com"));

			first.appendChild(name);
			first.appendChild(age);
			first.appendChild(email);

			DOMSource dom = new DOMSource(newDoc);
			Transformer transformer = TransformerFactory.newInstance().newTransformer();

			StreamResult result = new StreamResult(new File("src/main/resources/newfile.xml"));
			transformer.transform(dom, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
