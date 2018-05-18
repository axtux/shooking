package be.ac.ulb.infof307.g10.utils;

import org.junit.Assert;
import org.junit.Test;

import be.ac.ulb.infof307.g10.models.database.Database;

public class TestPreviewData {

	@Test
	public void databaseNotEmptyAfterPreviewDataAdded() {
		PreviewData.setPreviewData();
		Assert.assertFalse(Database.isEmpty());
	}

}
