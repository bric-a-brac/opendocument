package io.github.fabricetheytaz.opendocument.converter.old.html;

import org.xml.sax.Attributes;
import io.github.fabricetheytaz.opendocument.IOpenDocument;
import io.github.fabricetheytaz.opendocument.converter.old.TagElementConverter;
import io.github.fabricetheytaz.opendocument.converter.old.OpenDocumentConverter;
import io.github.fabricetheytaz.opendocument.text.IOpenDocumentText;

import static io.github.fabricetheytaz.util.Argument.notNull;

public class OpenDocumentToHTML extends OpenDocumentConverter
	{
	public OpenDocumentToHTML()
		{
		super();

		addConverter(IOpenDocumentText.LIST, "<ul>\n", "</ul>\n");
		addConverter(IOpenDocumentText.LIST_ITEM, "<li>", "</li>\n");
		addConverter(IOpenDocumentText.P, "<p>", "</p>\n");
		addConverter(IOpenDocumentText.SECTION, "<div>", "</div>\n");
		addConverter(IOpenDocumentText.SOFT_PAGE_BREAK, "", "<hr/>\n");
		addConverter(IOpenDocumentText.SPAN, "<span>", "</span>");
		}

	public final void addConverter(final String localName, final String startTag, final String endTag)
		{
		addConverter(IOpenDocument.TEXT_1_0, localName, startTag, endTag);
		}

	public final void addConverter(final String uri, final String localName, final String startTag, final String endTag)
		{
		addElementConverter(notNull(uri), notNull(localName), new TagElementConverter(startTag, endTag));
		}

	public static String getStyleName(final Attributes attributes)
		{
		return attributes.getValue(IOpenDocument.TEXT_1_0, IOpenDocumentText.STYLE_NAME);
		}
	}
