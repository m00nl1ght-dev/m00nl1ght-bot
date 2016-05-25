package com.gikk.twirk.types.userstate;

import static org.junit.Assert.assertTrue;

import com.gikk.twirk.types.USER_TYPE;
import com.gikk.twirk.types.twitchMessage.TwitchMessage;
import com.gikk.twirk.types.twitchMessage.TwitchMessageBuilderDefault;

public class TestUserstate {
	private static String USERSTATE_MOD = "@color=0x255;display-name=GikkBot;emote-sets=0;mod=1;subscriber=0;turbo=0;user-type=mod :tmi.twitch.tv USERSTATE #gikkman";
	private static String USERSTATE_USER = "@color=0x1234;display-name=GikkBot;emote-sets=0;mod=0;subscriber=0;turbo=0;user-type= :tmi.twitch.tv USERSTATE #gikkman";
	private static String USERSTATE_OWNER = "@color=#FF69B4;display-name=Gikkman;emote-sets=0,1454;mod=1;subscriber=0;turbo=0;user-type=mod :tmi.twitch.tv USERSTATE #gikkman";
	
	public static void test(){
		doTest(USERSTATE_MOD, "GikkBot", 0x255, USER_TYPE.MOD, new int[] {0} );
		doTest(USERSTATE_USER, "GikkBot", 0x1234, USER_TYPE.DEFAULT, new int[] {0} );
		doTest(USERSTATE_OWNER, "Gikkman", 0xFF69B4, USER_TYPE.OWNER, new int[] {0, 1454});
	}

	private static void doTest(String STRING, String displayName, int color, USER_TYPE UserType, int[] emotes) {
		TwitchMessage message = new TwitchMessageBuilderDefault().build(STRING);
		Userstate state = new UserstateBuilderDefault().build(message);
		
		assertTrue( state.getRaw().contentEquals(STRING) );
		assertTrue( state.getColor() == color );
		assertTrue( state.getDisplayName().contentEquals(displayName) );
		assertTrue( state.getUserType() == UserType );
		assertTrue( state.getEmoteSets().length == emotes.length );
		for( int i = 0; i < emotes.length; i++)
			assertTrue( state.getEmoteSets()[i] == emotes[i] );
		
	}
}
