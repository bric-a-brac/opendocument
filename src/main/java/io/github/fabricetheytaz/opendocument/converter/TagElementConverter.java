package io.github.fabricetheytaz.opendocument.converter;

import org.xml.sax.Attributes;

import static io.github.fabricetheytaz.util.Argument.notNull;

public class TagElementConverter extends AbstractElementConverter
	{
	private final String startTag;
	private final String endTag;

	public TagElementConverter(final String startTag, final String endTag)
		{
		super();

		this.startTag = notNull(startTag);
		this.endTag = notNull(endTag);
		}

	@Override
	public String start(final String uri, final String localName, final String qName, final Attributes attributes)
		{
		return startTag;
		}

	@Override
	public String end(final String uri, final String localName, final String qName)
		{
		return endTag;
		}
	}
