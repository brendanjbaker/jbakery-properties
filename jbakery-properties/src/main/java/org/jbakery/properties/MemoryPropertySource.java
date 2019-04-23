package org.jbakery.properties;

import java.util.Map;
import org.jbakery.arguments.Argument;

public class MemoryPropertySource
	implements PropertySource
{
	private final Map<String, String> propertiesMap;

	public MemoryPropertySource(final Map<String, String> propertiesMap)
	{
		this.propertiesMap = Argument.notNull(propertiesMap, "propertiesMap");
	}

	@Override
	public Map<String, String> toMap()
	{
		return propertiesMap;
	}
}
