package com.gikk.twirk.types.mode;

import static org.junit.Assert.assertTrue;

import com.gikk.twirk.types.mode.Mode.MODE_EVENT;
import com.gikk.twirk.types.twitchMessage.TwitchMessage;
import com.gikk.twirk.types.twitchMessage.TwitchMessageBuilderDefault;

public class TestMode {
	public static String GAIN_MOD = ":jtv MODE #gikkman +o gikkbot";
	public static String LOST_MOD = ":jtv MODE #gikkman -o gikkbot";
	
	
	public static void test(){
		doTest(GAIN_MOD, MODE_EVENT.GAINED_MOD, "gikkbot");
		doTest(LOST_MOD, MODE_EVENT.LOST_MOD, "gikkbot");
	}

	private static void doTest(String STRING, MODE_EVENT EVENT, String target) {
		TwitchMessage message = new TwitchMessageBuilderDefault().build(STRING);
		Mode mode = new ModeBuilderDefault().build(message);
		
		assertTrue("Got: " + mode.getEvent() + " Expected: " + EVENT  ,mode.getEvent() == EVENT);
		assertTrue("Got: " + mode.getUser()  + " Expected: " + target ,mode.getUser().contentEquals(target));
		assertTrue("Got: " + mode.getRaw()   + " Expected: " + STRING ,mode.getRaw().contentEquals(STRING));
		
	}
}
