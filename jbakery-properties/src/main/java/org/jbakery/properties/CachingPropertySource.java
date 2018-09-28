package org.jbakery.properties;

import java.util.Map;
import org.jbakery.arguments.Argument;
import org.jbakery.caching.Cache;

public class CachingPropertySource
	implements PropertySource
{
	private final PropertySource propertySource;
	private final Cache<PropertySource> propertySourceCache;

	public CachingPropertySource(Cache<PropertySource> propertySourceCache, PropertySource propertySource)
	{
		this.propertySource = Argument.notNull(propertySource, "propertySource");
		this.propertySourceCache = Argument.notNull(propertySourceCache, "propertySourceCache");
	}

	@Override
	public Map<String, String> toMap()
	{
		var cachedPropertySource = propertySourceCache.tryGet();

		if (cachedPropertySource != null)
			return cachedPropertySource.toMap();

		var propertyMap = propertySource.toMap();

		propertySourceCache.set(propertySource);

		return propertyMap;
	}
}
