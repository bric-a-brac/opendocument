package io.github.fabricetheytaz.opendocument.converter;

import io.github.fabricetheytaz.opendocument.text.IOpenDocumentText;

public class OpenDocumentTextConverter extends OpenDocumentConverter
	{
	public OpenDocumentTextConverter()
		{
		super();

		addStartElementConverter(IOpenDocumentText.SEQUENCE_DECL, element ->
			{
			dump(element);
			return "";
			});

		addStartElementConverter(IOpenDocumentText.P, element ->
			{
			//dump(element);
			return "<p>";
			});

		addEndElementConverter(IOpenDocumentText.P, element -> "</p>\n");

		//addElementConverter(IOpenDocumentText.SECTION, element -> "<section>", element -> "</section>\n");

		//addElementConverter(IOpenDocumentText.LIST, OPEN_LIST, CLOSE_LIST);
		}

	public final IElementConverter OPEN_LIST = element ->
		{
		//dump(element);

		return "<ol>";
		};

	public final IElementConverter CLOSE_LIST = element ->
		{
		return "</ol>";
		};
	}
