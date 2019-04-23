package org.jbakery.properties;

import org.jbakery.arguments.Argument;

public class Properties
{
	private final PropertySource propertySource;

	public Properties(final PropertySource propertySource)
	{
		this.propertySource = Argument.notNull(propertySource, "propertySource");
	}

	public boolean getBoolean(final String propertyName)
	{
		return Boolean.parseBoolean(read(propertyName));
	}

	public int getInteger(final String propertyName)
	{
		return Integer.parseInt(read(propertyName));
	}

	public long getLong(final String propertyName)
	{
		return Long.parseLong(read(propertyName));
	}

	public String getString(final String propertyName)
	{
		return read(propertyName);
	}

	public String read(final String propertyName)
	{
		Argument.notNull(propertyName, "propertyName");

		final var value = propertySource.toMap().get(propertyName);

		if (value == null)
			throw new PropertyNotFoundException(propertyName);

		return value;
	}
}
