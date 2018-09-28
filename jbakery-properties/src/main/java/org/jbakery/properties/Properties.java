package org.jbakery.properties;

import org.jbakery.arguments.Argument;

public class Properties
{
	private final PropertySource propertySource;

	public Properties(PropertySource propertySource)
	{
		this.propertySource = Argument.notNull(propertySource, "propertySource");
	}

	public boolean getBoolean(String propertyName)
	{
		return Boolean.parseBoolean(read(propertyName));
	}

	public int getInteger(String propertyName)
	{
		return Integer.parseInt(read(propertyName));
	}

	public long getLong(String propertyName)
	{
		return Long.parseLong(read(propertyName));
	}

	public String getString(String propertyName)
	{
		return read(propertyName);
	}

	public String read(String propertyName)
	{
		Argument.notNull(propertyName, "propertyName");

		var value = propertySource.toMap().get(propertyName);

		if (value == null)
			throw new PropertyNotFoundException(propertyName);

		return value;
	}
}
