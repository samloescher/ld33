package ludumdare._33.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.Player;
import ludumdare._33.assets.AnimationTextures;
import ludumdare._33.input.InputManager;
import ludumdare._33.sounds.SoundEffects;
import ludumdare._33.ui.UIOverlay;
import ludumdare._33.world.Background;
import ludumdare._33.world.World;
import ludumdare._33.world.cat.Cat;
import ludumdare._33.world.environment.HideableAreas;

public class GameScreen extends AbstractScreen {
	
	World world;
	Background background;
	
	UIOverlay uiOverlay;
	Matrix4 uiMatrix;
	
	Player player;
	
	InputManager inputManager;
	
	public static SoundEffects soundEffects = new SoundEffects();

	public GameScreen() {
		player = new Player();
		world = new World(player);
		background = new Background(camera);
		uiOverlay = new UIOverlay(player);
		uiMatrix = new Matrix4().setToOrtho2D(0, 0, 800, 480);
		inputManager = new InputManager(uiOverlay);
		Gdx.input.setInputProcessor(inputManager);
	}

	@Override
	void update(float delta) {
		world.update(delta);
		uiOverlay.setDetectionLevel(world.losePercent);
		uiOverlay.scoreDisplay.update(player.score);
		focusCameraOnCat(world.cat);
		background.update(delta);
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
		//world.drawDebug(shapeRenderer);
		
		shapeRenderer.setProjectionMatrix(uiMatrix);
		uiOverlay.drawDetectionMeter(shapeRenderer);
		
		batch.setProjectionMatrix(uiMatrix);
		batch.begin();
		uiOverlay.draw(batch);
		uiOverlay.scoreDisplay.draw(batch);
		batch.end();
	}

	@Override
	public void dispose() {
		AnimationTextures.dispose();
	}

	private void focusCameraOnCat(Cat cat) {
		Vector2 catPosition = cat.getCatPosition();
		float screenBuffer = 50;
		
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

	private void clampCameraToBounds() {
		camera.position.x = MathUtils.clamp(camera.position.x, World.bounds.x + camera.viewportWidth / 2,
				World.bounds.x + World.bounds.width - camera.viewportWidth / 2);
		camera.position.y = MathUtils.clamp(camera.position.y, World.bounds.y + camera.viewportHeight / 2,
				World.bounds.y + World.bounds.height - camera.viewportHeight / 2);
	}
}
