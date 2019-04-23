package org.jbakery.properties;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jbakery.arguments.Argument;

public class MultiplePropertySource
	implements PropertySource
{
	private final PropertySource[] propertySources;

	public MultiplePropertySource(PropertySource... propertySources)
	{
		this.propertySources = Argument.notNull(propertySources, "propertySources");
	}

	@Override
	public Map<String, String> toMap()
	{
		return Stream
			.of(propertySources)
			.map(PropertySource::toMap)
			.map(Map::entrySet)
			.flatMap(Collection::stream)
			.collect(
				Collectors.toMap(
					property -> property.getKey(),
					property -> property.getValue(),
					MergeStrategy::first));
	}
}
