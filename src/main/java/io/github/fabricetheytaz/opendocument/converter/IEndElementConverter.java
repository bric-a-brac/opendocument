package io.github.fabricetheytaz.opendocument.converter;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
@FunctionalInterface
public interface IEndElementConverter
	{
	/**
	 * @since 0.1.0
	 */
	public String end(String uri, String localName, String qName);
	}
