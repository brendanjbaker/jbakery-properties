package org.jbakery.properties;

import org.jbakery.arguments.Argument;

public class PropertyNotFoundException
	extends RuntimeException
{
	public PropertyNotFoundException(final String propertyName)
	{
		super(String.format("Property \"%s\" not found.", Argument.notNull(propertyName, "propertyName")));
	}
}
