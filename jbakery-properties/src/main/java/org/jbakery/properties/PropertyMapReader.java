package org.jbakery.properties;

import java.io.InputStream;
import java.util.Map;

public interface PropertyMapReader
{
	Map<String, String> read(InputStream inputStream);
}
