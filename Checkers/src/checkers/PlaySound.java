package checkers;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.IOException;

public class PlaySound extends Thread {

	private String filename;

	public PlaySound(String wavfile) {
		filename = wavfile;
	}

	public void run() {
        if(Checkers.silent) return;

		AudioStream audioStream;
		try {
			audioStream = new AudioStream(getClass().getResourceAsStream(filename));
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		AudioPlayer.player.start(audioStream);
	}
}
