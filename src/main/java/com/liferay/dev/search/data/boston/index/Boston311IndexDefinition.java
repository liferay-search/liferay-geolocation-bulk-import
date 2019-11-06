/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.dev.search.data.boston.index;

import com.liferay.portal.search.spi.index.IndexDefinition;

import org.osgi.service.component.annotations.Component;

/**
 * @author André de Oliveira
 */
@Component(
	immediate = true,
	property = {
		IndexDefinition.PROPERTY_KEY_INDEX_NAME + "=" +
						Boston311IndexDefinition.INDEX_NAME,
		IndexDefinition.PROPERTY_KEY_INDEX_SETTINGS_RESOURCE_NAME + "=" +
						Boston311IndexDefinition.TYPE_MAPPING_FILE_NAME
	},
	service = IndexDefinition.class
)
public class Boston311IndexDefinition implements IndexDefinition {

	public static final String INDEX_NAME = "boston311";

	public static final String TYPE_MAPPING_FILE_NAME = "boston311.json";

	public static final String TYPE_NAME = "_doc";

}