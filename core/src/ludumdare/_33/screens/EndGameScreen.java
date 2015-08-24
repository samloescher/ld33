package ludumdare._33.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import ludumdare._33.MainGame;

public class EndGameScreen extends AbstractScreen {

	int score;
	Texture catImage;

	public EndGameScreen(int score) {
		catImage = new Texture(Gdx.files.internal("images/cat/cat-end.png"));
		this.score = score;
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
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(catImage, 100, 0);
		font.draw(batch, "NICE! YOUR SCORE IS: "+ score, 20, 440);
		font.draw(batch, "Click anywhere\n to restart....", 540, 100);
		batch.end();
	}

}
