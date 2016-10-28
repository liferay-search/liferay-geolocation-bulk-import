package com.liferay.geolocation.bulk.util;

public class GeolocationDemoDatasetBulkLoader {

	public GeolocationDemoDatasetBulkLoader(
		JournalArticleBulkLoader journalArticleBulkLoader) {

		this.journalArticleBulkLoader = journalArticleBulkLoader;
	}

	public void load(int limit, boolean dryRun) throws Exception {
		GeolocationDemoDataset dataset = new Parser_311_requests_json().parse();

		journalArticleBulkLoader.setDataset(dataset);
		journalArticleBulkLoader.setLimit(limit);
		journalArticleBulkLoader.setDryRun(dryRun);

		journalArticleBulkLoader.load();
	}

	private final JournalArticleBulkLoader journalArticleBulkLoader;

}
