package ludumdare._33.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import ludumdare._33.sounds.Jukebox;
import ludumdare._33.world.World;

public class GameScreen extends AbstractScreen {

	World world;
	Jukebox jukeBox;

	public GameScreen() {
		world = new World();
		jukeBox = new Jukebox();
		
		jukeBox.play();
	}
	
	@Override
	void update(float delta) {
		world.update(delta);
	}

	@Override
	void draw() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		world.draw(batch);
		batch.end();
		
	}
	
	@Override
	public void dispose() {
		jukeBox.dispose();
	}

}