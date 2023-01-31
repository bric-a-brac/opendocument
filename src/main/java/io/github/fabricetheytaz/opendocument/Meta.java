package io.github.fabricetheytaz.opendocument;

import java.io.IOException;
import io.github.fabricetheytaz.util.dom.DocumentObjectModel;
import io.github.fabricetheytaz.util.dom.ElementHelper;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
public class Meta
	{
	private String creationDate;
	private String date;
	private String editingDuration;
	private String editingCycles;
	private String generator;

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

	public static final Meta from(final String xml) throws IOException
		{
		final DocumentObjectModel dom = new DocumentObjectModel(xml);

		final ElementHelper root = dom.getDocumentElement().getOneElement(IOpenDocument.OFFICE_1_0, "meta");

		final Meta meta = new Meta();

		root.getFirstElement(IOpenDocument.META_1_0, "creation-date").ifPresent(creationDate ->
			{
			meta.creationDate = creationDate.getTextContent();
			});

		root.getFirstElement(IOpenDocument.DC_1_1, "date").ifPresent(date ->
			{
			meta.date = date.getTextContent();
			});

		root.getFirstElement(IOpenDocument.META_1_0, "editing-duration").ifPresent(editingDuration ->
			{
			meta.editingDuration = editingDuration.getTextContent();
			});

		root.getFirstElement(IOpenDocument.META_1_0, "editing-cycles").ifPresent(editingCycles ->
			{
			meta.editingCycles = editingCycles.getTextContent();
			});

		root.getFirstElement(IOpenDocument.META_1_0, "generator").ifPresent(generator ->
			{
			meta.generator = generator.getTextContent();
			});

		return meta;
		}
	}
