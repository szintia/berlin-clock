package com.ubs.opsit.interviews;

import java.util.regex.Pattern;

public class TimeConverterImp implements TimeConverter {

	private static final String LINE_SEPARATOR = System.lineSeparator();
	private static final String FIRST_ROW_OFF = "0000";
	private static final String FIRST_ROW_ON = "RRRR";
	private static final String SECOND_ROW_OFF = FIRST_ROW_OFF;
	private static final String SECOND_ROW_ON = FIRST_ROW_ON;
	private static final String THIRD_ROW_OFF = "00000000000";
	private static final String THIRD_ROW_ON = "YYRYYRYYRYY";
	private static final String FOURTH_ROW_OFF = "0000";
	private static final String FOURTH_ROW_ON = "YYYY";
	private static final String OFF = "0";
	private static final Pattern TIME_PATTERN = Pattern.compile("[0-2][0-4]:[0-5][0-9]:[0-5][0-9]");
	private static final String YELLOW = "Y";

	@Override
	public String convertTime(String aTime) {

		if(aTime != null && TIME_PATTERN.matcher(aTime).matches()) {
				int hours = Integer.parseInt(aTime.substring(0, 2));
				int minutes = Integer.parseInt(aTime.substring(3, 5));
				int seconds = Integer.parseInt(aTime.substring(6, 8));
				
				String secondsLamp = (seconds % 2 == 0) ? YELLOW : OFF;
				
				int numberOfFirstRedLamps = hours / 5;
				int numberOfSecondRedLamps = hours % 5;
				int numberOfThirdLamps = minutes / 5;
				int numberOfFourthYellowLamps = minutes % 5;
				
				String firstRowOn = FIRST_ROW_ON.substring(0, numberOfFirstRedLamps);
				String firstRowOff = FIRST_ROW_OFF.substring(numberOfFirstRedLamps);
				String secondRowOn = SECOND_ROW_ON.substring(0, numberOfSecondRedLamps);
				String secondRowOff = SECOND_ROW_OFF.substring(numberOfSecondRedLamps);
				String thirdRowOn = THIRD_ROW_ON.substring(0, numberOfThirdLamps);
				String thirdRowOff = THIRD_ROW_OFF.substring(numberOfThirdLamps);
				String fourthRowOn = FOURTH_ROW_ON.substring(0, numberOfFourthYellowLamps);
				String fourthRowOff = FOURTH_ROW_OFF.substring(numberOfFourthYellowLamps);
				
				return new StringBuilder(secondsLamp).append(LINE_SEPARATOR)
						.append(firstRowOn).append(firstRowOff).append(LINE_SEPARATOR)
						.append(secondRowOn).append(secondRowOff).append(LINE_SEPARATOR)
						.append(thirdRowOn).append(thirdRowOff).append(LINE_SEPARATOR)
						.append(fourthRowOn).append(fourthRowOff).toString();
		}
		
		throw new RuntimeException();
	}
	
}
