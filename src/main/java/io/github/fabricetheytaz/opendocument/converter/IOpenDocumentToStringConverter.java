package io.github.fabricetheytaz.opendocument.converter;

import java.io.IOException;
import io.github.fabricetheytaz.opendocument.IOpenDocument;

public interface IOpenDocumentToStringConverter extends IOpenDocumentConverter<String>
	{
	/**
	 * @since 0.1.0
	 */
	public String convert(IOpenDocument document) throws IOException;
	}
