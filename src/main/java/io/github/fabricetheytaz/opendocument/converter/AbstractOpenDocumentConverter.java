package io.github.fabricetheytaz.opendocument.converter;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import io.github.fabricetheytaz.opendocument.IOpenDocument;

import static io.github.fabricetheytaz.util.Argument.notNull;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public abstract class AbstractOpenDocumentConverter implements IOpenDocumentConverter
	{
	private static final String KEY_FORMAT = "%s:%s";

	private final Map<String, IStartElementConverter> startConverters = new HashMap<>();
	private final Map<String, IEndElementConverter> endConverters = new HashMap<>();

	/**
	 * @since 0.1.0
	 */
	@Override
	public final void addStartElementConverter(final String uri, final String localName, final IStartElementConverter converter)
		{
		startConverters.put(key(uri, localName), notNull(converter));
		}

	/**
	 * @since 0.1.0
	 */
	@Override
	public final void addEndElementConverter(final String uri, final String localName, final IEndElementConverter converter)
		{
		endConverters.put(key(uri, localName), notNull(converter));
		}

	/**
	 * @since 0.1.0
	 */
	@Override
	public final IStartElementConverter getStartElementConverter(final String uri, final String localName)
		{
		return startConverters.get(key(uri, localName));
		}

	/**
	 * @since 0.1.0
	 */
	@Override
	public final IEndElementConverter getEndElementConverter(final String uri, final String localName)
		{
		return endConverters.get(key(uri, localName));
		}

	/**
	 * @since 0.1.0
	 */
	@Override
	public final void convert(final IOpenDocument document, final Consumer<String> consumer) throws IOException
		{
		parse(notNull(document).getEntry(IOpenDocument.CONTENT_XML), notNull(consumer));
		}

	/**
	 * @since 0.1.0
	 */
	private final void parse(final String xml, final Consumer<String> consumer) throws IOException
		{
		// TODO: Erreurs
		try
			{
			final SAXParser parser = SAXParserFactory.newDefaultNSInstance().newSAXParser();

			try (final Reader reader = new StringReader(notNull(xml)))
				{
				parser.parse(new InputSource(reader), new ConvertHandler(consumer));
				}
			}
		catch (final ParserConfigurationException ex)
			{
			throw new UnsupportedOperationException(ex);
			}
		catch (final SAXException ex)
			{
			throw new RuntimeException(ex);
			}
		}

	/**
	 * @since 0.1.0
	 */
	private final String key(final String uri, final String localName)
		{
		return String.format(KEY_FORMAT, notNull(uri), notNull(localName));
		}

	/**
	 * @version 0.1.0
	 * @since 0.1.0
	 */
	private final class ConvertHandler extends DefaultHandler
		{
		private final Consumer<String> consumer;

		public ConvertHandler(final Consumer<String> consumer)
			{
			super();

			this.consumer = consumer;
			}

		@Override
		public void startElement(final String uri, final String localName, final String qName, final Attributes attributes)
			{
			final IStartElementConverter converter = getStartElementConverter(uri, localName);

			if (converter != null)
				{
				consumer.accept(converter.start(uri, localName, qName, attributes));
				}
			}

		@Override
		public void endElement(final String uri, final String localName, final String qName)
			{
			final IEndElementConverter converter = getEndElementConverter(uri, localName);

			if (converter != null)
				{
				consumer.accept(converter.end(uri, localName, qName));
				}
			}

		@Override
		public void characters(final char[] ch, final int start, final int length)
			{
			// FIXME: Et merde ça marchait bien jusque là grrrrrrrrrrrrrrr mais oui T c'est pas String !!!!!!!!!!!!
			consumer.accept(new String(ch, start, length));
			}
		}
	}
