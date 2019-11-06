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
import com.liferay.portal.search.internal.document.DocumentBuilderFactoryImpl;
import com.liferay.portal.search.internal.geolocation.GeoBuildersImpl;

import java.util.stream.Stream;

/**
 * @author André de Oliveira
 */
public class Request311ToSearchDocumentTranslatorDemo {

	public static void main(String[] args) throws Exception {
		Parser_311_requests_json json = new Parser_311_requests_json();

		GeolocationDemoDataset dataset = json.parse();

		Request311ToSearchDocumentTranslator translator =
			new Request311ToSearchDocumentTranslator(
				new DocumentBuilderFactoryImpl(), new GeoBuildersImpl());

		Stream<Document> documentsStream = dataset.entries()
		.map(translator::translate);

		Stream stream = documentsStream.map(Document::getFields);

		/*
		import com.liferay.portal.search.elasticsearch6.internal.document.DefaultElasticsearchDocumentFactory;
		import com.liferay.portal.search.elasticsearch6.internal.document.ElasticsearchDocumentFactory;

		ElasticsearchDocumentFactory elasticsearchDocumentFactory =
			new DefaultElasticsearchDocumentFactory();

		stream = documentsStream
		.map(elasticsearchDocumentFactory::getElasticsearchDocument)
		.map(org.elasticsearch.common.Strings::toString);
		*/

		stream.forEach(System.out::println);

		System.out.println(
			"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"
			+ "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}

}
