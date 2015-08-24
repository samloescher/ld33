package ludumdare._33.sounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Jukebox {

	static Music backgroundMusic;
	
	static Jukebox instance;
	
	public static Jukebox getInstance(){
		if(instance == null){
			instance = new Jukebox();
		}
		return instance;
	}
	
	private Jukebox () {
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/happy-pixel-adventure.mp3"));
		backgroundMusic.setVolume(0.1f);
		backgroundMusic.setLooping(true);
	}

	public static void play() {
		backgroundMusic.play();
	}
	
	public static void pause() {
		backgroundMusic.pause();
	}
	
	public static void dispose() {
		backgroundMusic.dispose();
	}
}
