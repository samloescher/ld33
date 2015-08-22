package ludumdare._33.sounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundEffects {

	Sound catEatingSound;
	Sound catGrowlingSound;
	Sound catMeowingSound;
	Sound pointsSound;

	public SoundEffects() {
		catEatingSound = Gdx.audio.newSound(Gdx.files.internal("sounds/cat/cat-eating.ogg"));
		catGrowlingSound = Gdx.audio.newSound(Gdx.files.internal("sounds/cat/cat-growls.mp3"));
		catMeowingSound = Gdx.audio.newSound(Gdx.files.internal("sounds/cat/cat-meowing.mp3"));
		pointsSound = Gdx.audio.newSound(Gdx.files.internal("sounds/points.mp3"));
	}

	public void playEatingSound() {
		long soundID = catEatingSound.play();
		catEatingSound.setVolume(soundID, 0.5f);
	}

	public void playGrowlingSound() {
		long soundID = catGrowlingSound.play();
		catGrowlingSound.setVolume(soundID, 0.5f);
	}

	public void playMeowSound() {
		long soundID = catMeowingSound.play();
		catMeowingSound.setVolume(soundID, 0.5f);
	}

	public void playPointsSound() {
		long soundID = pointsSound.play();
		pointsSound.setVolume(soundID, 0.2f);
	}

	public void dispose() {
		catEatingSound.dispose();
		catGrowlingSound.dispose();
		catMeowingSound.dispose();
		pointsSound.dispose();
	}
}
