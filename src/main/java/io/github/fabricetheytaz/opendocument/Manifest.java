package io.github.fabricetheytaz.opendocument;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import io.github.fabricetheytaz.util.dom.DocumentObjectModel;

public final class Manifest
	{
	private final Map<String, String> entries;

	private Manifest(final Map<String, String> entries)
		{
		super();

		this.entries = entries;
		}

	public Map<String, String> getEntries()
		{
		return Collections.unmodifiableMap(entries);
		}

	/**
	 * @throws NullArgumentException
	 * @throws DocumentObjectModelException
	 * @throws IOException
	 */
	public static final Manifest from(final String xml) throws IOException
		{
		final DocumentObjectModel dom = new DocumentObjectModel(xml);

		final Map<String, String> entries = new HashMap<>();

		dom.getDocumentElement().getElements(IOpenDocument.MANIFEST_1_0, "file-entry").forEach(fileEntry ->
			{
			System.out.println("file-entry");
			// TODO DOM getAttribute :)
			});

		/*
		// Huuum pas si top XPath finalement...

		final String query = String.format("/%s:%s/%s:%s", IOpenDocument.MANIFEST_1_0, "manifest", IOpenDocument.MANIFEST_1_0, "file-entry");

		final NodeList nodes = dom.selectNodeList(query);

		

		for (int i = 0; i < nodes.getLength(); i++)
			{
			final Node node = nodes.item(i);

			// TODO: Version
			/*
			if (node.getAttributes().getNamedItemNS(IOpenDocument.MANIFEST_1_0, "version") != null)
				{
				System.out.println("Version");
				}
			* /

			final String fullPath = node.getAttributes().getNamedItemNS(IOpenDocument.MANIFEST_1_0, "full-path").getNodeValue();
			final String mediaType = node.getAttributes().getNamedItemNS(IOpenDocument.MANIFEST_1_0, "media-type").getNodeValue();

			entries.put(fullPath, mediaType);
			}
		*/

		return new Manifest(entries);
		}
	}
