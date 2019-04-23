package org.jbakery.properties;

import java.util.Collections;
import java.util.Map;
import org.jbakery.arguments.Argument;

public class ExceptionSuppressingPropertySource
	implements PropertySource
{
	private final PropertySource propertySource;

	public ExceptionSuppressingPropertySource(final PropertySource propertySource)
	{
		this.propertySource = Argument.notNull(propertySource, "propertySource");
	}

	@Override
	public Map<String, String> toMap()
	{
		try
		{
			return propertySource.toMap();
		}
		catch (final Exception e)
		{
			return Collections.emptyMap();
		}
	}
}
