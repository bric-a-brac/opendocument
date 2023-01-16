package io.github.fabricetheytaz.opendocument;

import java.io.IOException;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public interface IOpenDocument extends AutoCloseable
	{
	public static final String TEXT_1_0 = "urn:oasis:names:tc:opendocument:xmlns:text:1.0";

	public static final String CONTENT_XML = "/content.xml";

	public static final String MANIFEST_XML = "/META-INF/manifest.xml";

	public static final String MIMETYPE = "/mimetype";

	/**
	 * @since 0.1.0
	 */
	public String getEntry(String path) throws IOException;

	/**
	 * @since 0.1.0
	 */
	@Override
	public void close() throws IOException;
	}
