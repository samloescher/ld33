package ludumdare._33.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import ludumdare._33.MainGame;

public class MainMenuScreen extends AbstractScreen {

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
		font.draw(batch, "WELCOME TO THE CAT GAME...", 100, 150);
		font.draw(batch, "TAP ANYWHERE TO BEGIN!", 100, 100);
		batch.end();

		if (Gdx.input.isTouched()) {
			MainGame.instance.setScreen(new GameScreen());
			dispose();
		}
	}
}
