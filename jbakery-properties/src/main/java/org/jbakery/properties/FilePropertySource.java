package org.jbakery.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import org.jbakery.arguments.Argument;

public class FilePropertySource
	implements PropertySource
{
	private final String path;
	private final PropertyMapReader propertyMapReader;

	public FilePropertySource(String path, PropertyMapReader propertyMapReader)
	{
		this.path = Argument.notNull(path, "path");
		this.propertyMapReader = Argument.notNull(propertyMapReader, "propertyMapReader");
	}

	@Override
	public Map<String, String> toMap()
	{
		try (var inputStream = new FileInputStream(path))
		{
			return propertyMapReader.read(inputStream);
		}
		catch (IOException ioe)
		{
			throw new RuntimeException(ioe);
		}
	}
}
