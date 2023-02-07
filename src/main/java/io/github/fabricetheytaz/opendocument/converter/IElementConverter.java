package io.github.fabricetheytaz.opendocument.converter;

import java.util.function.Function;
import org.w3c.dom.Element;

/**
 * @version 0.1.0
 * @since 0.1.0
 */
@FunctionalInterface
public interface IElementConverter extends Function<Element, String>
	{
	public static final IElementConverter EMPTY = element -> "";
	}
