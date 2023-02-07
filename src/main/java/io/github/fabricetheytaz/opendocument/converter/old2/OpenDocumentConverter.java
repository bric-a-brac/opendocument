package io.github.fabricetheytaz.opendocument.converter.old2;

public class OpenDocumentConverter //extends AbstractNodeParser
	{
	/*
	protected IElementConverter<Element> startText = element -> element.getTextContent();

	protected IElementConverter<Element> startParagraph = element -> "<p>";
	protected IElementConverter<Element> endParagraph = element -> "</p>";

	protected IElementConverter<Element> startSpan = element -> "<span>";
	protected IElementConverter<Element> endSpan = element -> "</span>";

	protected IElementConverter<Element> startList = element -> "<ul>";
	protected IElementConverter<Element> endList = element -> "</ul>";

	protected IElementConverter<Element> startListItem = element -> "<li>";
	protected IElementConverter<Element> endListItem = element -> "</li>";

	protected IElementConverter<Element> startSection = element -> "<div>";
	protected IElementConverter<Element> endSection = element -> "</div>";
	*/

	/*
	public final String parse(final Document document)
		{
		// FIXME: Pas top class one shoot !!!!!!!!!!!!!!!

		builder = new StringBuilder();

		visit(document);

		return builder.toString();
		}
	*/

	/*
	@Override
	public final void startElement(final Element element, final int level)
		{
		if (namespace == IOpenDocument.TEXT_1_0)
			{
			switch (name)
				{
				case IOpenDocumentText.P:
					//accept(startParagraph.apply(element));
					break;
				case IOpenDocumentText.SPAN:
					//accept(startSpan.apply(element));
					break;
				case IOpenDocumentText.LIST:
					//accept(startList.apply(element));
					break;
				case IOpenDocumentText.LIST_ITEM:
					//accept(startListItem.apply(element));
					break;
				case IOpenDocumentText.SECTION:
					//accept(startSection.apply(element));
					break;
				}
			}
		}

	@Override
	public final void endElement(final Element element, final int level)
		{
		final String name = element.getLocalName();
		final String namespace = element.getNamespaceURI();

		if (namespace == IOpenDocument.TEXT_1_0)
			{
			switch (name)
				{
				case IOpenDocumentText.P:
					//accept(endParagraph.apply(element));
					break;
				case IOpenDocumentText.SPAN:
					//accept(endSpan.apply(element));
					break;
				case IOpenDocumentText.LIST:
					//accept(endList.apply(element));
					break;
				case IOpenDocumentText.LIST_ITEM:
					//accept(endListItem.apply(element));
					break;
				case IOpenDocumentText.SECTION:
					//accept(endSection.apply(element));
					break;
				}
			}
		}
	*/

	/*
	public static final String convert(final IOpenDocument document) throws IOException
		{
		final String xml = document.getEntry(IOpenDocument.CONTENT_XML);

		final Document dom = DocumentObjectModel.parse(xml);

		final Custom converter = new Custom();

		converter.parse(dom);

		return converter.toString();
		}
	*/
	}
