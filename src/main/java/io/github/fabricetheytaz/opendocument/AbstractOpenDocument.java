package io.github.fabricetheytaz.opendocument;

import java.io.IOException;
import java.nio.file.Path;
import io.github.fabricetheytaz.util.zip.ZipArchive;

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
	@Override
	public final String getEntry(final String path) throws IOException
		{
		return read(path);
		}

	/**
	 * @since 0.1.0
	 */
	@Override
	public final Manifest getManifest() throws IOException
		{
		return Manifest.from(getEntry(MANIFEST_XML));
		}

	/**
	 * @since 0.1.0
	 */
	@Override
	public final Meta getMeta() throws IOException
		{
		return Meta.from(getEntry(META_XML));
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
