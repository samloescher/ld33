package ludumdare._33.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import ludumdare._33.MainGame;

public class EndGameScreen extends AbstractScreen {

	Texture catImage;

	public EndGameScreen() {
		catImage = new Texture(Gdx.files.internal("images/cat/cat-end.png"));
	}

	@Override
	void update(float delta) {
	}

	@Override
	void draw() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		batch.draw(catImage, 200, 0);
		font.draw(batch, "YOU HAVE FAILED...", 20, 440);
		font.draw(batch, "Tap anywhere to restart....", 20, 400);
		batch.end();

		if (Gdx.input.isTouched()) {
			MainGame.instance.setScreen(new GameScreen());
			catImage.dispose();
			dispose();
		}
	}

}
