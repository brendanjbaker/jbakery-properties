package org.jbakery.properties;

import java.io.IOException;
import java.util.Map;
import org.jbakery.arguments.Argument;

public class ClasspathPropertySource
	implements PropertySource
{
	private final String path;
	private final PropertyMapReader propertyMapReader;

	public ClasspathPropertySource(String path, PropertyMapReader propertyMapReader)
	{
		this.path = Argument.notNull(path, "path");
		this.propertyMapReader = Argument.notNull(propertyMapReader, "propertyMapReader");
	}

	@Override
	public Map<String, String> toMap()
	{
		try (var inputStream = this.getClass().getResourceAsStream(path))
		{
			return propertyMapReader.read(inputStream);
		}
		catch (IOException ioe)
		{
			throw new RuntimeException(ioe);
		}
	}
}
