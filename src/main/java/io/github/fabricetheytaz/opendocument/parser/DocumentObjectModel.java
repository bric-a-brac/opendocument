package io.github.fabricetheytaz.opendocument.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import static io.github.fabricetheytaz.util.Argument.notNull;

public class DocumentObjectModel
	{
	private final XPath xpath;
	private final Document document;

	public DocumentObjectModel(final Document document)
		{
		super();

		xpath = XPathFactory.newInstance().newXPath();

		this.document = notNull(document);
		}

	public DocumentObjectModel(final String xml) throws IOException, SAXException
		{
		this(parse(xml));
		}

	public Object select(final String expression, final QName qName)
		{
		try
			{
			return xpath.compile(notNull(expression)).evaluate(document, notNull(qName));
			}
		catch (final XPathExpressionException ex)
			{
			// TODO: Erreur
			throw new RuntimeException(ex);
			}
		}

	public String selectString(final String expression)
		{
		return (String) select(expression, XPathConstants.STRING);
		}

	public Double selectNumber(final String expression)
		{
		return (Double) select(expression, XPathConstants.NUMBER);
		}

	public Node selectNode(final String expression)
		{
		return (Node) select(expression, XPathConstants.NODE);
		}

	public NodeList selectNodeList(final String expression)
		{
		return (NodeList) select(expression, XPathConstants.NODESET);
		}

	public static final  Document parse(final Reader reader, final boolean withNamespaceSupport) throws IOException, SAXException
		{
		return newDocumentBuilder(withNamespaceSupport).parse(new InputSource(notNull(reader)));
		}

	public static final  Document parse(final Reader reader) throws IOException, SAXException
		{
		return parse(reader, true);
		}

	public static final Document parse(final String xml, final boolean withNamespaceSupport) throws IOException, SAXException
		{
		try (final Reader reader = new StringReader(notNull(xml)))
			{
			return parse(reader, withNamespaceSupport);
			}
		}

	public static final Document parse(final String xml) throws IOException, SAXException
		{
		return parse(xml, true);
		}

	/**
	 * @throws UnsupportedOperationException
	 * 
	 * @todo Erreur création parser
	 */
	private static final DocumentBuilder newDocumentBuilder(final boolean withNamespaceSupport)
		{
		try
			{
			final DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();

			factory.setNamespaceAware(withNamespaceSupport);

			return factory.newDocumentBuilder();
			}
		catch (final ParserConfigurationException ex)
			{
			// TODO: Erreur Parser
			throw new UnsupportedOperationException(ex);
			}
		}

	/*
		
		builder.parse(new InputSource(new StringReader("dsd")));
		final Document document = builder.newDocument();
		final Element element = document.createElementNS("sddd", "sdsd");
		document.getDocumentElement().appendChild(element);
		}
	*/
	}
