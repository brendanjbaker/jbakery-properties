package org.jbakery.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.stream.Collectors;
import org.jbakery.arguments.Argument;

public class PlatformPropertyMapReader
	implements PropertyMapReader
{
	@Override
	public Map<String, String> read(final InputStream inputStream)
	{
		Argument.notNull(inputStream, "inputStream");

		try
		{
			final var properties = new java.util.Properties();

			properties.load(inputStream);

			return properties
				.entrySet()
				.stream()
				.collect(
					Collectors.toMap(
						property -> property.getKey().toString(),
						property -> property.getValue().toString()));
		}
		catch (final IOException ioe)
		{
			throw new RuntimeException(ioe);
		}
	}
}
