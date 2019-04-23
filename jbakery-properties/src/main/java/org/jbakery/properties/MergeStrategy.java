package org.jbakery.properties;

class MergeStrategy
{
	private MergeStrategy() { }

	public static <T> T first(final T alpha, final T beta)
	{
		return alpha;
	}
}
