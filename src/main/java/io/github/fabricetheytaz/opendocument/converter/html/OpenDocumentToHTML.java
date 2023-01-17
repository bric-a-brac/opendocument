package io.github.fabricetheytaz.opendocument.converter.html;

import io.github.fabricetheytaz.opendocument.IOpenDocument;
import io.github.fabricetheytaz.opendocument.converter.OpenDocumentConverter;
import io.github.fabricetheytaz.opendocument.converter.TagElementConverter;
import io.github.fabricetheytaz.opendocument.text.IOpenDocumentText;

import static io.github.fabricetheytaz.util.Argument.notNull;

public class OpenDocumentToHTML extends OpenDocumentConverter
	{
	public OpenDocumentToHTML()
		{
		super();

		addConverter(IOpenDocumentText.P, "<p>", "</p>\n");
		addConverter(IOpenDocumentText.SECTION, "<div>", "</div>\n");

		/*
		addStartElementConverter(IOpenDocument.TEXT_1_0, IOpenDocumentText.P, (uri, localName, qName, attributes) ->
			{
			final String style = attributes.getValue(IOpenDocument.TEXT_1_0, IOpenDocumentText.STYLE_NAME);

			if (style != null)
				{
				return "<p class=\"" + style + "\">";
				}

			return "<p>";
			});

		addEndElementConverter(IOpenDocument.TEXT_1_0, IOpenDocumentText.P, (uri, localName, qName) -> "</p>\n");

		addElementConverter(IOpenDocument.TEXT_1_0, IOpenDocumentText.SECTION, new TagElementConverter("<div>", "</div>\n"));

		addStartElementConverter(IOpenDocument.TEXT_1_0, IOpenDocumentText.SOFT_PAGE_BREAK, (uri, localName, qName, attributes) -> "<hr/>\n");
		*/
		}

	public final void addConverter(final String localName, final String startTag, final String endTag)
		{
		addConverter(IOpenDocument.TEXT_1_0, localName, startTag, endTag);
		}

	public final void addConverter(final String uri, final String localName, final String startTag, final String endTag)
		{
		addElementConverter(notNull(uri), notNull(localName), new TagElementConverter(startTag, endTag));
		}

	/*
	public final void addParagraphConverter()
		{
		addConverter(IOpenDocumentText.P, "<p>", "</p>\n");
		}
	*/
	}
