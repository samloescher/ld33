package ludumdare._33.sounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Jukebox {

	public Music backgroundMusic;

	public void play() {
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/happy-pixel-adventure.mp3"));
		backgroundMusic.setVolume(0.1f);
		backgroundMusic.setLooping(true);
		backgroundMusic.play();
	}
	
	public void dispose() {
		backgroundMusic.dispose();
	}
}
