package ludumdare._33;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class GameScreen implements Screen {

	final MainGame game;
	Texture img;
	OrthographicCamera camera;

	public GameScreen(final MainGame gameGame) {
		this.game = gameGame;

		img = new Texture("images/badlogic.jpg");

		/* Create the camera and the SpriteBatch */
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		/* Clear the screen and add a white background */
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		/* Begin a new batch */
		game.batch.begin();
		game.batch.draw(img, 400, 240);
		game.batch.end();
	}

	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
		img.dispose();
	}

}