package io.github.fabricetheytaz.opendocument;

import java.io.IOException;
import java.util.OptionalInt;
import io.github.fabricetheytaz.util.dom.DocumentObjectModel;
import io.github.fabricetheytaz.util.dom.ElementHelper;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public class Meta
	{
	private static final String DC = IOpenDocument.DC_1_1;
	private static final String META = IOpenDocument.META_1_0;
	private static final String OFFICE = IOpenDocument.OFFICE_1_0;

	private String creationDate;
	private String date;
	private String editingDuration;
	private String editingCycles;
	private String generator;
	private String title;
	private Statistics statistics = new Statistics();

	/**
	 * @since 0.1.0
	 */
	public final String getCreationDate()
		{
		return creationDate;
		}

	/**
	 * @since 0.1.0
	 */
	public final String getDate()
		{
		return date;
		}

	/**
	 * @since 0.1.0
	 */
	public final String getEditingDuration()
		{
		return editingDuration;
		}

	/**
	 * @since 0.1.0
	 */
	public final String getEditingCycles()
		{
		return editingCycles;
		}

	/**
	 * @since 0.1.0
	 */
	public final String getGenerator()
		{
		return generator;
		}

	/**
	 * @since 0.1.0
	 */
	public final String getTitle()
		{
		return title;
		}

	/**
	 * @since 0.1.0
	 */
	public final Statistics getStatistics()
		{
		return statistics;
		}

	/**
	 * @since 0.1.0
	 */
	public static final Meta from(final String xml) throws IOException
		{
		final DocumentObjectModel dom = new DocumentObjectModel(xml);

		final ElementHelper root = dom.getDocumentElement().getOneElement(OFFICE, "meta");

		final Meta meta = new Meta();

		root.getFirstElement(META, "creation-date").ifPresent(creationDate ->
			{
			meta.creationDate = creationDate.getTextContent();
			});

		root.getFirstElement(DC, "date").ifPresent(date ->
			{
			meta.date = date.getTextContent();
			});

		root.getFirstElement(META, "editing-duration").ifPresent(editingDuration ->
			{
			meta.editingDuration = editingDuration.getTextContent();
			});

		root.getFirstElement(META, "editing-cycles").ifPresent(editingCycles ->
			{
			meta.editingCycles = editingCycles.getTextContent();
			});

		root.getFirstElement(META, "generator").ifPresent(generator ->
			{
			meta.generator = generator.getTextContent();
			});

		root.getFirstElement(DC, "title").ifPresent(title ->
			{
			meta.title = title.getTextContent();
			});

		root.getFirstElement(META, "document-statistic").ifPresent(documentStatistic ->
			{
			meta.statistics = Statistics.from(documentStatistic);
			});

		return meta;
		}

	/**
	 * @version 0.1.0
	 * @since 0.1.0
	 */
	public static class Statistics
		{
		private int tableCount = 0;
		private int imageCount = 0;
		private int objectCount = 0;
		private int pageCount = 0;
		private int paragraphCount = 0;
		private int wordCount = 0;
		private int characterCount = 0;
		private int nonWhitespaceCharacterCount = 0;

		/**
		 * @since 0.1.0
		 */
		public final int getTableCount()
			{
			return tableCount;
			}

		/**
		 * @since 0.1.0
		 */
		public final int getImageCount()
			{
			return imageCount;
			}

		/**
		 * @since 0.1.0
		 */
		public final int getObjectCount()
			{
			return objectCount;
			}

		/**
		 * @since 0.1.0
		 */
		public final int getPageCount()
			{
			return pageCount;
			}

		/**
		 * @since 0.1.0
		 */
		public final int getParagraphCount()
			{
			return paragraphCount;
			}

		/**
		 * @since 0.1.0
		 */
		public final int getWordCount()
			{
			return wordCount;
			}

		/**
		 * @since 0.1.0
		 */
		public final int getCharacterCount()
			{
			return characterCount;
			}

		/**
		 * @since 0.1.0
		 */
		public final int getNonWhitespaceCharacterCount()
			{
			return nonWhitespaceCharacterCount;
			}

		/**
		 * @since 0.1.0
		 */
		// TODO: Dans Util DOM :)
		private static OptionalInt asInt(final String value)
			{
			if (value == null || value.isBlank())
				{
				return OptionalInt.empty();
				}

			try
				{
				return OptionalInt.of(Integer.parseInt(value));
				}
			catch (final NumberFormatException ex)
				{
				return OptionalInt.empty();
				}
			}

		/**
		 * @since 0.1.0
		 */
		private static Statistics from(final ElementHelper elementHelper)
			{
			final Statistics statistics = new Statistics();

			asInt(elementHelper.getAttribute(META, "table-count")).ifPresent(count -> statistics.tableCount = count);
			asInt(elementHelper.getAttribute(META, "image-count")).ifPresent(count -> statistics.imageCount = count);
			asInt(elementHelper.getAttribute(META, "object-count")).ifPresent(count -> statistics.objectCount = count);
			asInt(elementHelper.getAttribute(META, "page-count")).ifPresent(count -> statistics.pageCount = count);
			asInt(elementHelper.getAttribute(META, "paragraph-count")).ifPresent(count -> statistics.paragraphCount = count);
			asInt(elementHelper.getAttribute(META, "word-count")).ifPresent(count -> statistics.wordCount = count);
			asInt(elementHelper.getAttribute(META, "character-count")).ifPresent(count -> statistics.characterCount = count);
			asInt(elementHelper.getAttribute(META, "non-whitespace-character-count")).ifPresent(count -> statistics.nonWhitespaceCharacterCount = count);

			return statistics;
			}
		}
	}
