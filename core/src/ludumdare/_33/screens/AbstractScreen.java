package ludumdare._33.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractScreen implements Screen {
	
	public static SpriteBatch batch = new SpriteBatch();
	public static BitmapFont font = new BitmapFont(Gdx.files.internal("fonts/I-pixel-u.fnt"),false);
	public static OrthographicCamera camera = new OrthographicCamera(800, 480);

	@Override
	public void show() {
		camera.setToOrtho(false);
	}
	
	abstract void update(float delta);
	abstract void draw();

	@Override
	public final void render(float delta) {
		update(delta);
		draw();
	}

	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(false, width, height);
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
		
	}

}
