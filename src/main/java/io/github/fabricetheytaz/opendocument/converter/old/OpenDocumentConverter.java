package io.github.fabricetheytaz.opendocument.converter.old;

import java.io.IOException;
import io.github.fabricetheytaz.opendocument.IOpenDocument;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public class OpenDocumentConverter extends AbstractOpenDocumentConverter
	{
	@Override
	public final String convert(final IOpenDocument document) throws IOException
		{
		final StringBuilder builder = new StringBuilder();

		convert(document, (result) -> builder.append(result));

		return builder.toString();
		}
	}
