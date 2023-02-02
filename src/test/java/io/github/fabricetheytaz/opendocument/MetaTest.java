package io.github.fabricetheytaz.opendocument;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.github.fabricetheytaz.opendocument.Meta.Statistics;
import io.github.fabricetheytaz.opendocument.text.OpenDocumentText;

public class MetaTest extends Assertions
	{
	@Test
	public void test() throws IOException
		{
		final Path path = Paths.get("tests", "meta.odt");

		try (final IOpenDocument document = new OpenDocumentText(path))
			{
			assertNotNull(document);

			final Meta meta = document.getMeta();

			assertNotNull(meta);

			assertEquals("Titre", meta.getTitle());

			assertEquals("P0D", meta.getEditingDuration());

			//assertEquals("0", meta.getEditingCycles()); // 0 ???? Même pas 1 au moins ??????????

			final Statistics statistics = meta.getStatistics();

			assertNotNull(statistics);

			assertEquals(1, statistics.getPageCount());
			assertEquals(0, statistics.getTableCount());
			assertEquals(0, statistics.getObjectCount());
			assertEquals(5, statistics.getParagraphCount()); // Texte par défaut est aussi un paragraphe !!
			assertEquals(13, statistics.getWordCount());
			assertEquals(80, statistics.getCharacterCount());
			assertEquals(72, statistics.getNonWhitespaceCharacterCount());
			}
		}
	}
