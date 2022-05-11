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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTask {

	private static DocumentBuilder builder;

	public void enteringDocument() {
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new File("src/main/resources/data.xml"));
			doc.getDocumentElement().normalize();
			NodeList passengerList = doc.getElementsByTagName("passenger");

			for (int i = 0; i < passengerList.getLength(); i++) {
				NodeList nodeList = passengerList.item(i).getChildNodes();
				Node current;
				for (int z = 0; z < nodeList.getLength(); z++) {
					current = nodeList.item(z);
					if (current.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println(current.getNodeName() + ": " + current.getTextContent());
					}
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	private static void printDom(Document document) throws Exception {
		DOMSource dom = new DOMSource(document);
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
