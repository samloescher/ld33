package ludumdare._33;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ludumdare._33.screens.MainMenuScreen;

public class MainGame extends Game {
	public static MainGame instance;

	public SpriteBatch batch;
	public BitmapFont font;
	public Music backgroundMusic;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("fonts/I-pixel-u.fnt"), false);
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/happy-pixel-adventure.mp3"));
		
		backgroundMusic.setVolume(0.1f);
		backgroundMusic.setLooping(true);
		backgroundMusic.play();

		instance = this;
		setScreen(new MainMenuScreen());
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
		backgroundMusic.dispose();
	}
}
