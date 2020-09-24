package com.liferay.geolocation.bulk.command;

import com.liferay.geolocation.bulk.util.GeolocationDemoDatasetBulkLoader;
import com.liferay.geolocation.bulk.util.JournalArticleBulkLoader;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(
				immediate = true, service = GeolocationBulkLoadCommand.class,
	property = {
		"osgi.command.function=load",
		"osgi.command.scope=geolocation"
	}
)
public class GeolocationBulkLoadCommand {

	public void load(String limit) throws Exception {
		boolean dryRun = false;
		new GeolocationDemoDatasetBulkLoader(journalArticleBulkLoader).load(
			Integer.valueOf(limit), dryRun);
	}

	public void load() throws Exception {
		load("10");
	}

	@Activate
	protected void start() {
		System.out.println("Geolocation Bulk Load is ready...");
	}

	@Deactivate
	protected void stop() {
		System.out.println("Geolocation Bulk Load deactivated...");
	}

	@Reference
	protected JournalArticleBulkLoader journalArticleBulkLoader;

}