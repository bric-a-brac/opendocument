package io.github.fabricetheytaz.opendocument.converter;

import java.io.IOException;
import java.util.function.Consumer;
import io.github.fabricetheytaz.opendocument.IOpenDocument;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public interface IOpenDocumentConverter<T>
	{
	/**
	 * @since 0.1.0
	 */
	public void addStartElementConverter(String uri, String localName, IStartElementConverter<T> converter);

	/**
	 * @since 0.1.0
	 */
	public void addEndElementConverter(String uri, String localName, IEndElementConverter<T> converter);

	/**
	 * @since 0.1.0
	 */
	public default void addElementConverter(final String uri, final String localName, final IElementConverter<T> converter)
		{
		addStartElementConverter(uri, localName, converter);
		addEndElementConverter(uri, localName, converter);
		}

	/**
	 * @since 0.1.0
	 */
	public IStartElementConverter<T> getStartElementConverter(String uri, String localName);

	/**
	 * @since 0.1.0
	 */
	public IEndElementConverter<T> getEndElementConverter(String uri, String localName);

	/**
	 * @since 0.1.0
	 */
	public void convert(IOpenDocument document, Consumer<T> consumer) throws IOException;
	}
