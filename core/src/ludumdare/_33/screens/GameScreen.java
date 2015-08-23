package ludumdare._33.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.input.InputProcessing;
import ludumdare._33.sounds.Jukebox;
import ludumdare._33.sounds.SoundEffects;
import ludumdare._33.ui.UIOverlay;
import ludumdare._33.world.Background;
import ludumdare._33.world.World;
import ludumdare._33.world.environment.HideableAreas;
import ludumdare._33.world.environment.Platforms;

public class GameScreen extends AbstractScreen {
	
	World world;
	Background background;
	
	Jukebox jukeBox;
	SoundEffects soundEffects;
	UIOverlay uiOverlay;
	Matrix4 uiMatrix;
	
	InputProcessing inputProcessing;

	public GameScreen() {
		world = new World();
		jukeBox = new Jukebox();
		soundEffects = new SoundEffects();
		background = new Background(camera);
		uiOverlay = new UIOverlay();
		uiMatrix = new Matrix4().setToOrtho2D(0, 0, 800, 480);
		inputProcessing = new InputProcessing(uiOverlay);
		Gdx.input.setInputProcessor(inputProcessing);
		
		jukeBox.play();
	}

	@Override
	void update(float delta) {
		world.update(delta);
		focusCameraOnCat();
		background.update();
	}

	@Override
	void draw() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		background.draw(batch);
		world.draw(batch);
		batch.end();

		shapeRenderer.setColor(Color.RED);
		shapeRenderer.setProjectionMatrix(camera.combined);
		//Platforms.draw(shapeRenderer);
		HideableAreas.draw(shapeRenderer);
		world.drawDebug(shapeRenderer);
		
		
		batch.setProjectionMatrix(uiMatrix);
		batch.begin();
		uiOverlay.draw(batch);
		batch.end();
	}

	@Override
	public void dispose() {
		jukeBox.dispose();
		soundEffects.dispose();
	}

	void focusCameraOnCat() {
		Vector2 catPosition = world.getCatPosition();
		float screenBuffer = 125;
		
		float maxX = camera.position.x + screenBuffer;
		if (catPosition.x > maxX) {
			camera.position.x = catPosition.x - screenBuffer;
		}
		float minX = camera.position.x - screenBuffer;
		if (catPosition.x < minX) {
			camera.position.x = catPosition.x + screenBuffer;
		}
		
		float maxY = camera.position.y + screenBuffer / 3;
		if (catPosition.y > maxY) {
			camera.position.y = catPosition.y - screenBuffer / 3;
		}
		float minY = camera.position.y + screenBuffer / 4;
		if (catPosition.y < minY) {
			camera.position.y = catPosition.y - screenBuffer / 4;
		}
		clampCameraToBounds();
		camera.update();
	}

	void clampCameraToBounds() {
		camera.position.x = MathUtils.clamp(camera.position.x, World.bounds.x + camera.viewportWidth / 2,
				World.bounds.x + World.bounds.width - camera.viewportWidth / 2);
		camera.position.y = MathUtils.clamp(camera.position.y, World.bounds.y + camera.viewportHeight / 2,
				World.bounds.y + World.bounds.height - camera.viewportHeight / 2);
	}
}
