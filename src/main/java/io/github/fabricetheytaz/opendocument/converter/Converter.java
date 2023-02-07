package io.github.fabricetheytaz.opendocument.converter;

import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import io.github.fabricetheytaz.util.dom.ElementVisitor;

import static io.github.fabricetheytaz.util.Argument.notNull;

public class Converter
	{
	protected final Map<String, IOpenDocumentConverter> converters = new HashMap<>();

	public final void addOpenDocumentConverter(final String namespace, final IOpenDocumentConverter converter)
		{
		converters.put(notNull(namespace), notNull(converter));
		}

	public final String convert(final Document document)
		{
		final Visitor visitor = new Visitor();

		visitor.visit(document);

		return visitor.builder.toString();
		}

	private class Visitor extends ElementVisitor
		{
		private final StringBuilder builder = new StringBuilder();

		@Override
		public void startElement(final Element element, final int level)
			{
			builder.append(converters.getOrDefault(element.getNamespaceURI(), IOpenDocumentConverter.EMPTY).start(element));
			}

		@Override
		public void endElement(final Element element, final int level)
			{
			builder.append(converters.getOrDefault(element.getNamespaceURI(), IOpenDocumentConverter.EMPTY).end(element));
			}

		@Override
		public void startText(final Text text, final int level)
			{
			builder.append(text.getTextContent());
			}
		}
	}
