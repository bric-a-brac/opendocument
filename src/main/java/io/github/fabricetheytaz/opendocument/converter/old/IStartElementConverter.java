package io.github.fabricetheytaz.opendocument.converter.old;

import org.xml.sax.Attributes;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
@FunctionalInterface
public interface IStartElementConverter
	{
	/**
	 * @since 0.1.0
	 */
	public String start(String uri, String localName, String qName, Attributes attributes);
	}
