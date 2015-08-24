package ludumdare._33.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import ludumdare._33.MainGame;

abstract class AbstractScreen implements Screen {
	
	public static SpriteBatch batch = MainGame.instance.batch;
	public static ShapeRenderer shapeRenderer = MainGame.instance.shapeRenderer;
	public static BitmapFont font = MainGame.instance.font;
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
