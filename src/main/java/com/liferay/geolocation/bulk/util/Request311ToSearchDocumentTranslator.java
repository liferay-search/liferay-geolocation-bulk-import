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

package com.liferay.geolocation.bulk.util;

import com.liferay.portal.search.document.Document;
import com.liferay.portal.search.document.DocumentBuilder;
import com.liferay.portal.search.document.DocumentBuilderFactory;
import com.liferay.portal.search.geolocation.GeoBuilders;

/**
 * @author André de Oliveira
 */
public class Request311ToSearchDocumentTranslator {

	private final DocumentBuilderFactory _documentBuilderFactory;
	private final GeoBuilders _geoBuilders;

	public Request311ToSearchDocumentTranslator(
		DocumentBuilderFactory documentBuilderFactory,
		GeoBuilders geoBuilders) {

		_documentBuilderFactory = documentBuilderFactory;
		_geoBuilders = geoBuilders;
	}

	public Document translate(Request311 r) {
		DocumentBuilder documentBuilder = _documentBuilderFactory.builder();

		Document document = documentBuilder
			.setString("case_enquiry_id", r.case_enquiry_id)
			.setString("case_status", r.case_status)
			.setString("case_title", r.case_title)
			.setString("city_council_district", r.city_council_district)
			.setInteger(
				"city_council_district", getInteger(r.city_council_district))
			.setDate("closed_dt", r.closed_dt == null ? null : r.closed_dt)
			.setString("closure_reason", r.closure_reason)
			.setString("department", r.department)
			.setInteger("fire_district", getInteger(r.fire_district))
			.setGeoLocationPoint(
				"geolocation",
				_geoBuilders.geoLocationPoint(
					Double.valueOf(r.latitude), Double.valueOf(r.longitude)))
			.setString("location", r.location)
			.setString("neighborhood", r.neighborhood)
			.setString("reason", r.reason)
			.setString("source", r.source)
			.setString("type", r.type)
			.build();

		return document;
	}

	private static Integer getInteger(String string) {
		return string == null ? null : Integer.valueOf(string);
	}
}
