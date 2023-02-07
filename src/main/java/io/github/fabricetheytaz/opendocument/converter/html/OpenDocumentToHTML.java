package io.github.fabricetheytaz.opendocument.converter.html;

import java.io.IOException;
import io.github.fabricetheytaz.opendocument.IOpenDocument;
import io.github.fabricetheytaz.opendocument.converter.Converter;
import io.github.fabricetheytaz.opendocument.converter.OpenDocumentConverter;
import io.github.fabricetheytaz.opendocument.text.IOpenDocumentText;
import io.github.fabricetheytaz.util.dom.DocumentObjectModel;
import io.github.fabricetheytaz.util.emoji.Emojify;

import static io.github.fabricetheytaz.util.Argument.notNull;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public final class OpenDocumentToHTML extends Converter
	{
	/**
	 * @since 0.1.0
	 */
	public OpenDocumentToHTML(final String pathToEmojisProperties) throws IOException
		{
		super(new Emojify(notNull(pathToEmojisProperties)));

		addOpenDocumentConverter(IOpenDocument.TEXT_1_0, new OpenDocumentTextToHTML());
		}

	/**
	 * @since 0.1.0
	 */
	public String convert(final IOpenDocument document) throws IOException
		{
		return convert(DocumentObjectModel.parse(document.getEntry(IOpenDocument.CONTENT_XML)));
		}
	/**
	 * @version 0.1.0
	 * @since 0.1.0
	 */
	private class OpenDocumentTextToHTML extends OpenDocumentConverter
		{
		/**
		 * @since 0.1.0
		 */
		public OpenDocumentTextToHTML() throws IOException
			{
			super();

			loadFromResource("/text.tags");

			addElementConverter(IOpenDocumentText.P, element -> "<p>", element -> "</p>\n");
			}
		}
	}
