package io.github.fabricetheytaz.opendocument.converter;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import static io.github.fabricetheytaz.util.Argument.notNull;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public class OpenDocumentConverter implements IOpenDocumentConverter
	{
	protected final Map<String, IElementConverter> startConverters = new HashMap<>();
	protected final Map<String, IElementConverter> endConverters = new HashMap<>();

	/**
	 * @since 0.1.0
	 */
	public final void addElementConverter(final String nodeName, final IElementConverter startConverter, final IElementConverter endConverter)
		{
		addStartElementConverter(nodeName, startConverter);
		addEndElementConverter(nodeName, endConverter);
		}

	/**
	 * @since 0.1.0
	 */
	public final void addStartElementConverter(final String nodeName, final IElementConverter converter)
		{
		startConverters.put(notNull(nodeName), notNull(converter));
		}

	/**
	 * @since 0.1.0
	 */
	public final void addEndElementConverter(final String nodeName, final IElementConverter converter)
		{
		endConverters.put(notNull(nodeName), notNull(converter));
		}

	/**
	 * @since 0.1.0
	 */
	@Override
	public String start(final Element element)
		{
		notNull(element);

		return startConverters.getOrDefault(element.getLocalName(), IElementConverter.EMPTY).apply(element);
		}

	/**
	 * @since 0.1.0
	 */
	@Override
	public String end(final Element element)
		{
		notNull(element);

		return endConverters.getOrDefault(element.getLocalName(), IElementConverter.EMPTY).apply(element);
		}

	protected void dump(final Element element)
		{
		final NamedNodeMap attributes = element.getAttributes();

		final int length = attributes.getLength();

		for (int i = 0; i < length; i++)
			{
			final Attr attribute = (Attr) attributes.item(i);

			System.out.println(String.format(" - %s=%s (%s)", attribute.getLocalName(), attribute.getValue(), attribute.getNamespaceURI()));
			}
		}

	public final void loadFromResource(final String resource) throws IOException
		{
		try (final InputStream stream = getClass().getResourceAsStream(resource))
			{
			final Properties properties = new Properties();

			properties.load(stream);

			properties.keySet().forEach(key ->
				{
				final String[] node = key.toString().split("\\.", 2);

				final String nodeName = node[0];
				final String openOrClose = node[1];

				final String tag = properties.getProperty(key.toString());

				if (openOrClose.equalsIgnoreCase("open"))
					{
					addStartElementConverter(nodeName, element -> tag);
					}
				else if (openOrClose.equalsIgnoreCase("close"))
					{
					addEndElementConverter(nodeName, element -> tag);
					}
				});
			}
		}
	}
