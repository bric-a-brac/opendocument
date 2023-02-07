package io.github.fabricetheytaz.opendocument.converter.old;

import java.io.IOException;
import java.util.function.Consumer;
import io.github.fabricetheytaz.opendocument.IOpenDocument;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public interface IOpenDocumentConverter
	{
	/**
	 * @since 0.1.0
	 */
	public void addStartElementConverter(String uri, String localName, IStartElementConverter converter);

	/**
	 * @since 0.1.0
	 */
	public void addEndElementConverter(String uri, String localName, IEndElementConverter converter);

	/**
	 * @since 0.1.0
	 */
	public default void addElementConverter(final String uri, final String localName, final IElementConverter converter)
		{
		addStartElementConverter(uri, localName, converter);
		addEndElementConverter(uri, localName, converter);
		}

	/**
	 * @since 0.1.0
	 */
	public IStartElementConverter getStartElementConverter(String uri, String localName);

	/**
	 * @since 0.1.0
	 */
	public IEndElementConverter getEndElementConverter(String uri, String localName);

	/**
	 * @since 0.1.0
	 */
	public String convert(IOpenDocument document) throws IOException;

	/**
	 * @since 0.1.0
	 */
	public void convert(IOpenDocument document, Consumer<String> consumer) throws IOException;
	}
