package io.github.fabricetheytaz.opendocument;

import java.nio.file.Files;
import java.nio.file.Paths;
import io.github.fabricetheytaz.opendocument.converter.html.OpenDocumentToHTML;
import io.github.fabricetheytaz.opendocument.parser.DocumentObjectModel;
import io.github.fabricetheytaz.opendocument.text.OpenDocumentText;

public class Dev
	{
	public static void parser() throws Exception
		{
		final String xml = "<root><text>Text ;-)</text><child/><child/><child/></root>";

		final DocumentObjectModel dom = new DocumentObjectModel(xml);

		System.out.println(dom.selectString("/root/text"));

		System.out.println(dom.selectNode("/root").getLocalName());

		System.out.println(dom.selectNodeList("/root/child").getLength());

		//System.out.println(dom.selectNumber("//count(*)"));
		}

	public static void manifest() throws Exception
		{
		try (final IOpenDocument document = new OpenDocumentText(Paths.get("/home/thefab/Documents/Code/OpenDocument/documents/dev-to-plaintext.odt")))
			{
			final Manifest manifest = document.getManifest();

			manifest.getEntries().forEach((fullPath, mediaType) ->
				{
				System.out.println(String.format("%s (%s)", fullPath, mediaType));
				});
			}
		}

	public static void html() throws Exception
		{
		try (final IOpenDocument document = new OpenDocumentText(Paths.get("/home/thefab/Documents/Code/OpenDocument/documents/dev-to-plaintext.odt")))
			{
			final OpenDocumentToHTML converter = new OpenDocumentToHTML();

			final String html = converter.convert(document);

			System.out.println(html);

			Files.writeString(Paths.get(".", "OpenDocumentToHTML.html"), html);
			}
		}

	public static void main(String[] args) throws Exception
		{
		//parser();
		//manifest();
		html();
		}
	}
