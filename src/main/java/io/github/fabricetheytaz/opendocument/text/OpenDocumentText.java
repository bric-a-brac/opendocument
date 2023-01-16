package io.github.fabricetheytaz.opendocument.text;

import java.io.IOException;
import java.nio.file.Path;
import io.github.fabricetheytaz.opendocument.AbstractOpenDocument;
import io.github.fabricetheytaz.util.exceptions.NullArgumentException;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public class OpenDocumentText extends AbstractOpenDocument implements IOpenDocumentText
	{
	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public OpenDocumentText(final Path path) throws IOException
		{
		super(path);
		}
	}
