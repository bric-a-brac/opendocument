package io.github.fabricetheytaz.opendocument.converter;

import org.w3c.dom.Element;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public interface IOpenDocumentConverter
	{
	public static final IOpenDocumentConverter EMPTY = new IOpenDocumentConverter()
		{
		@Override
		public String start(Element element)
			{
			return "";
			}

		@Override
		public String end(Element element)
			{
			return "";
			}
		};

	/**
	 * @since 0.1.0
	 */
	public String start(Element element);

	/**
	 * @since 0.1.0
	 */
	public String end(Element element);
	}
