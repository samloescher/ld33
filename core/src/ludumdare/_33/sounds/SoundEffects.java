package ludumdare._33.sounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundEffects {
	
	public float volume = 1f;
	
	Sound catMeowingSound;
	Sound pointsSound;

	public SoundEffects() {
		catMeowingSound = Gdx.audio.newSound(Gdx.files.internal("sounds/cat/cat-meowing.mp3"));
		pointsSound = Gdx.audio.newSound(Gdx.files.internal("sounds/points.mp3"));
	}

	public void playMeowSound() {
		long soundID = catMeowingSound.play();
		catMeowingSound.setVolume(soundID, 0.5f * volume);
	}

	public void playPointsSound() {
		long soundID = pointsSound.play();
		pointsSound.setVolume(soundID, 0.2f * volume);
	}
	
	public void stopAllSounds() {
		catMeowingSound.stop();
		pointsSound.stop();
	}

	public void dispose() {
		catMeowingSound.dispose();
		pointsSound.dispose();
	}
}
