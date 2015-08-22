package ludumdare._33;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ludumdare._33.screens.MainMenuScreen;

public class MainGame extends Game {
	public static MainGame instance;

	public SpriteBatch batch;
	public BitmapFont font;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal("fonts/I-pixel-u.fnt"), false);

		instance = this;
		setScreen(new MainMenuScreen());
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}
