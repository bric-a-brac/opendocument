package io.github.fabricetheytaz.opendocument.converter;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
@FunctionalInterface
public interface IEndElementConverter<T>
	{
	/**
	 * @since 0.1.0
	 */
	public T end(String uri, String localName, String qName);
	}
