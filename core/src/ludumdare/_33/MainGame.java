package ludumdare._33;

import com.badlogic.gdx.Game;

import ludumdare._33.screens.AbstractScreen;
import ludumdare._33.screens.MainMenuScreen;

public class MainGame extends Game {
	public static MainGame instance;

	@Override
	public void create() {
		instance = this;
		setScreen(new MainMenuScreen());
	}
	
	public void dispose(){
		AbstractScreen.batch.dispose();
		AbstractScreen.font.dispose();
	}
}
