package org.jbakery.properties;

import java.io.InputStream;
import java.util.Map;
import org.jbakery.arguments.Argument;

public class InputStreamPropertySource
	implements PropertySource
{
	private final InputStream inputStream;
	private final PropertyMapReader propertyMapReader;

	public InputStreamPropertySource(InputStream inputStream, PropertyMapReader propertyMapReader)
	{
		this.inputStream = Argument.notNull(inputStream, "inputStream");
		this.propertyMapReader = Argument.notNull(propertyMapReader, "propertyMapReader");
	}

	@Override
	public Map<String, String> toMap()
	{
		return propertyMapReader.read(inputStream);
	}
}
