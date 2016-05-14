package com.gikk.twirc.events;

import com.gikk.twirc.messages.TwirkHostNotice;
import com.gikk.twirc.messages.TwirkMessage;
import com.gikk.twirc.messages.TwirkMode;
import com.gikk.twirc.messages.TwirkNotice;
import com.gikk.twirc.messages.TwirkRoomstate;
import com.gikk.twirc.messages.TwirkUser;
import com.gikk.twirc.messages.TwirkUserstate;

public interface TwirkListener {	
	
	public void onAnything( String line );
	
	public void onPrivMsg( TwirkUser sender, TwirkMessage message );
	
	public void onWhisper( TwirkUser sender, TwirkMessage message );
	
	public void onJoin( String joinedNick );
	
	public void onPart( String partedNick );

	public void onConnect();
	
	public void onDisconnect();
	
	public void onNotice( TwirkNotice notice );
	
	public void onHost( TwirkHostNotice hostNotice );
	
	public void onMode( TwirkMode mode );

	public void onUserstate( TwirkUserstate userstate );

	public void onRoomstate( TwirkRoomstate roomstate );

	public void onUnknown( String line );
}
