package io.github.fabricetheytaz.opendocument.converter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.w3c.dom.Document;
import io.github.fabricetheytaz.opendocument.IOpenDocument;
import io.github.fabricetheytaz.opendocument.text.OpenDocumentText;
import io.github.fabricetheytaz.util.dom.DocumentObjectModel;

public class Dev
	{
	public static void convert() throws IOException
		{
		final OpenDocumentTextConverter textConverter = new OpenDocumentTextConverter();

		// TODO: Avant Ctor :) !!!!!!!!!!!
		//textConverter.loadFromResource("/text.tags");

		final Converter converter = new Converter();

		converter.addOpenDocumentConverter(IOpenDocument.TEXT_1_0, textConverter);

		final Path path = Paths.get("/home/thefab/Documents/Code/GitHub/OpenDocuments/Dev.odt");

		try (final IOpenDocument document = new OpenDocumentText(path))
			{
			final Document dom = DocumentObjectModel.parse(document.getEntry(IOpenDocument.CONTENT_XML));

			final String html = converter.convert(dom);

			System.out.println(html);
			}
		}

	public static void main(String[] args) throws Exception
		{
		convert();
		}
	}
