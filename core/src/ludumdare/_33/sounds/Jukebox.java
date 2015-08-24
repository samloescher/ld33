package ludumdare._33.sounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Jukebox {

	static Music backgroundMusic;
	
	static{
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
	
	public static void setVolume(float volume){
		backgroundMusic.setVolume(0.1f * volume);
	}
	
	public static float getVolume(){
		return backgroundMusic.getVolume();
	}
	
	public static void dispose() {
		backgroundMusic.dispose();
	}
}
