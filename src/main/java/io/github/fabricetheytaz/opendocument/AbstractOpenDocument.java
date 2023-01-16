package io.github.fabricetheytaz.opendocument;

import java.io.IOException;
import java.nio.file.Path;
import io.github.fabricetheytaz.util.ZipArchive;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public abstract class AbstractOpenDocument extends ZipArchive implements IOpenDocument
	{
	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public AbstractOpenDocument(final Path path) throws IOException
		{
		super(path);
		}

	/**
	 * @since 0.1.0
	 */
	public final String getEntry(final String path) throws IOException
		{
		return read(path);
		}
	/*
	public final String getEntry(final String path) throws IOException
		{
		read(path);
		return read(zip.getPath(path));
		//throw new UnsupportedOperationException();
		}
	*/
	}
