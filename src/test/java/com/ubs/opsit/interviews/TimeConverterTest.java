package com.ubs.opsit.interviews;

import org.junit.Test;

import junit.framework.Assert;

public class TimeConverterTest {
	
	private static final String LINE_SEPARATOR = System.lineSeparator();
	private static final String CONVERTED_START_OF_DAY_MIDNIGHT = "Y" + LINE_SEPARATOR + "OOOO" + LINE_SEPARATOR + "OOOO" + LINE_SEPARATOR + "OOOOOOOOOOO" + LINE_SEPARATOR + "OOOO";
	private static final String START_OF_DAY_MIDNIGHT = "00:00:00";
	private static final String CONVERTED_MIDDLE_OF_THE_AFTERNOON = "O" + LINE_SEPARATOR + "RROO" + LINE_SEPARATOR + "RRRO" + LINE_SEPARATOR + "YYROOOOOOOO" + LINE_SEPARATOR + "YYOO";
	private static final String MIDDLE_OF_THE_AFTERNOON = "13:17:01";
	private static final String CONVERTED_JUST_BEFORE_MIDNIGHT = "O" + LINE_SEPARATOR + "RRRR" + LINE_SEPARATOR + "RRRO" + LINE_SEPARATOR + "YYRYYRYYRYY" + LINE_SEPARATOR + "YYYY";
	private static final String JUST_BEFORE_MIDNIGHT = "23:59:59";
	private static final String CONVERTED_END_OF_DAY_MIDNIGHT = "Y" + LINE_SEPARATOR + "RRRR" + LINE_SEPARATOR + "RRRR" + LINE_SEPARATOR + "OOOOOOOOOOO" + LINE_SEPARATOR + "OOOO";
	private static final String END_OF_DAY_MIDNIGHT = "24:00:00";
	
	private TimeConverter timeConverter; 
	
	@Test
	public void testMidnight() {
		Assert.assertEquals(CONVERTED_START_OF_DAY_MIDNIGHT, timeConverter.convertTime(START_OF_DAY_MIDNIGHT));
	}
	
	@Test
	public void testMiddleOfTheAfternoon() {
		Assert.assertEquals(CONVERTED_MIDDLE_OF_THE_AFTERNOON, timeConverter.convertTime(MIDDLE_OF_THE_AFTERNOON));
	}
	
	@Test
	public void testJustBeforeMidnight() {
		Assert.assertEquals(CONVERTED_JUST_BEFORE_MIDNIGHT, timeConverter.convertTime(JUST_BEFORE_MIDNIGHT));
	}
	
	@Test
	public void testMidnight2() {
		Assert.assertEquals(CONVERTED_END_OF_DAY_MIDNIGHT, timeConverter.convertTime(END_OF_DAY_MIDNIGHT));
	}
}
