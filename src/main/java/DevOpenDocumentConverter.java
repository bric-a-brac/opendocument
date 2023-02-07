
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.w3c.dom.Document;
import io.github.fabricetheytaz.opendocument.IOpenDocument;
import io.github.fabricetheytaz.opendocument.converter.Converter;
import io.github.fabricetheytaz.opendocument.converter.OpenDocumentTextConverter;
import io.github.fabricetheytaz.opendocument.converter.html.OpenDocumentToHTML;
import io.github.fabricetheytaz.opendocument.text.OpenDocumentText;
import io.github.fabricetheytaz.util.dom.DocumentObjectModel;
import io.github.fabricetheytaz.util.emoji.Emojify;

public class DevOpenDocumentConverter
	{
	public static void dev() throws IOException
		{
		final OpenDocumentTextConverter textConverter = new OpenDocumentTextConverter();

		// TODO: Avant (Dans) Ctor :) !!!!!!!!!!!
		//textConverter.loadFromResource("/text.tags");

		final Converter converter = new Converter(new Emojify("emojis.properties"));

		converter.addOpenDocumentConverter(IOpenDocument.TEXT_1_0, textConverter);

		final Path path = Paths.get("/home/thefab/Documents/Code/GitHub/OpenDocuments/Dev.odt");

		try (final IOpenDocument document = new OpenDocumentText(path))
			{
			final Document dom = DocumentObjectModel.parse(document.getEntry(IOpenDocument.CONTENT_XML));

			final String html = converter.convert(dom);

			System.out.println(html);
			}
		}

	public static void dev2() throws IOException
		{
		final Path path = Paths.get("/home/thefab/Documents/Code/GitHub/OpenDocuments/Dev.odt");

		final OpenDocumentToHTML odt2html = new OpenDocumentToHTML("emojis.properties");

		try (final IOpenDocument document = new OpenDocumentText(path))
			{
			final String html = odt2html.convert(document);

			System.out.println(html);
			}
		}
	}
