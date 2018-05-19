package be.ac.ulb.infof307.g10.models;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class TestShop {

	private Map<DayOfWeek, String> schedule = new HashMap<>();

	@Test(expected = IllegalArgumentException.class)
	public void nullName() {
		new Shop(null, 0., 0.);
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptyName() {
		new Shop("", 0., 0.);
	}

	@Test(expected = IllegalArgumentException.class)
	public void spaceName() {
		new Shop("  ", 0., 0.);
	}

	@Test
	public void unknownSchedule() {
		Shop s = new Shop("name", 0., 0.);
		for (DayOfWeek day : DayOfWeek.values()) {
			Assert.assertEquals("Unknown", s.getSchedule(day));
		}
	}

	@Test
	public void emptySchedule() {
		schedule.put(DayOfWeek.WEDNESDAY, "");
		Shop s = new Shop("name", 0., 0., schedule);
		Assert.assertEquals("Unknown", s.getSchedule(DayOfWeek.WEDNESDAY));
	}

	@Test
	public void spaceSchedule() {
		schedule.put(DayOfWeek.WEDNESDAY, "  ");
		Shop s = new Shop("name", 0., 0., schedule);
		Assert.assertEquals("Unknown", s.getSchedule(DayOfWeek.WEDNESDAY));
	}

	@Test
	public void schedule() {
		schedule.put(DayOfWeek.WEDNESDAY, "daySchedule");
		Shop s = new Shop("name", 0., 0., schedule);
		Assert.assertEquals("daySchedule", s.getSchedule(DayOfWeek.WEDNESDAY));
	}

	@Test
	public void stockNotNull() {
		Shop shop = new Shop("name", 0., 0.);
		Assert.assertNotNull(shop.getStock());
	}
	
	@Test
	public void position() {
		Shop shop = new Shop("name", 13., 42.);
		Assert.assertEquals(13., shop.getLatitude(), 0);
		Assert.assertEquals(42., shop.getLongitude(), 0);
	}
}
