package checkers;

import com.apple.eio.FileManager;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlaySound extends Thread {

	private String filename;

	private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb

	enum Position {LEFT, RIGHT, NORMAL}

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
