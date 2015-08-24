package ludumdare._33.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import ludumdare._33.MainGame;

public class MainMenuScreen extends AbstractScreen {

	Texture catImage;

	public MainMenuScreen() {
		catImage = new Texture(Gdx.files.internal("images/cat/cat-intro.png"));
	}

	@Override
	void update(float delta) {

	}

	@Override
	void draw() {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		batch.draw(catImage, 300, 0);
		font.draw(batch, "WELCOME TO THE CAT MONSTER GAME...", 20, 440);
		font.draw(batch, "TAP ANYWHERE TO BEGIN!", 20, 400);
		font.draw(batch, "Instructions:", 20, 340);
		font.draw(batch, "WASD TO MOVE", 20, 300);
		font.draw(batch, "EAT FOOD \n  FOR POINTS", 20, 260);
		font.draw(batch, "DON'T GET \n  CAUGHT BY \n   HUMANS...", 20, 160);
		batch.end();

		if (Gdx.input.isTouched()) {
			MainGame.instance.setScreen(new GameScreen());
			catImage.dispose();
			dispose();
		}
	}
}
