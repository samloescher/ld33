package ludumdare._33.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class GameScreen extends AbstractScreen {

	Texture img;

	public GameScreen() {
		img = new Texture("images/badlogic.jpg");
	}
	
	@Override
	void update(float delta) {
		
	}

	@Override
	void draw() {
		
		/* Clear the screen and add a white background */
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		/* Begin a new batch */
		batch.begin();
		batch.draw(img, 400, 240);
		batch.end();
		
	}
	
	@Override
	public void dispose() {
		img.dispose();
	}

	

}