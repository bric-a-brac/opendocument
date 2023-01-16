package io.github.fabricetheytaz.opendocument.converter;

import org.xml.sax.Attributes;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
@FunctionalInterface
public interface IStartElementConverter<T>
	{
	/**
	 * @since 0.1.0
	 */
	public T start(String uri, String localName, String qName, Attributes attributes);
	}
