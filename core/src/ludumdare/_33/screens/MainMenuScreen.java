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
		if (Gdx.input.isTouched()) {
			MainGame.instance.setScreen(new GameScreen());
			catImage.dispose();
			dispose();
		}
	}

	@Override
	void draw() {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		batch.draw(catImage, 520, 20,200,400);
		font.draw(batch, "KILLER CAT", 280, 440);
		
		font.draw(batch, "Instructions:", 20, 360);
		font.draw(batch, "WASD to move", 20, 320);
		font.draw(batch, "Bring presents HOME \n  for POINTS", 20, 280);
		font.draw(batch, "and don't get SEEN", 20, 180);
		
		font.draw(batch, "CLICK anywhere to BEGIN!", 20, 100);
		batch.end();

		
	}
}
