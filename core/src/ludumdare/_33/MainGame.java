package ludumdare._33;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ludumdare._33.screens.MainMenuScreen;

public class MainGame extends Game {
	public static MainGame instance;
	
	public static SpriteBatch batch = new SpriteBatch();
	public static BitmapFont font = new BitmapFont(Gdx.files.internal("fonts/I-pixel-u.fnt"),false);

	@Override
	public void create() {
		instance = this;
		setScreen(new MainMenuScreen());
	}
	
	public void dispose(){
		batch.dispose();
		font.dispose();
	}
}
