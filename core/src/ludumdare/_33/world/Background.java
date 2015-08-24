package ludumdare._33.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

import ludumdare._33.assets.StaticTextures;
import ludumdare._33.world.environment.Star;

public class Background {
	Sprite cloudsLeft;
	Sprite cloudsCenter;
	Sprite cloudsRight;
	
	Sprite hillsLeft;
	Sprite hillsCenter;
	Sprite hillsRight;
	
	Star star;
	
	Rectangle cameraViewport = new Rectangle();
	OrthographicCamera camera;
	
	ArrayList<Star> starsArray = new ArrayList<Star>();
	
	public Background(OrthographicCamera camera) {
		this.camera = camera;
		assignSprites();
		generateStars();
	}
	
	public void update(float delta){
		updateCameraViewportBounds();
		adjustTexturePositionsToCoverScreen();
		
		for (Star s : starsArray) {
			s.update(delta);
		}
	}
	
	private void updateCameraViewportBounds(){
		cameraViewport.x = camera.position.x - camera.viewportWidth/2;
		cameraViewport.y = camera.position.y - camera.viewportHeight/2;
		cameraViewport.width = camera.viewportWidth;
		cameraViewport.height = camera.viewportHeight;
	}
	
	private void adjustTexturePositionsToCoverScreen(){
		int leftTexturePositionIndex;
		float textureWidth;
		float parallaxOffset;
		
		textureWidth = cloudsLeft.getWidth();
		parallaxOffset = (cameraViewport.x * 0.3f) % textureWidth;
		
		leftTexturePositionIndex = (int) ((cameraViewport.x)  / textureWidth);
		cloudsLeft.setPosition((leftTexturePositionIndex - 1) * textureWidth + parallaxOffset, 40);
		cloudsCenter.setPosition((leftTexturePositionIndex) * textureWidth + parallaxOffset, 40);
		cloudsRight.setPosition((leftTexturePositionIndex + 1) * textureWidth + parallaxOffset, 40);
		
		textureWidth = hillsLeft.getWidth();
		parallaxOffset = (cameraViewport.x * 0.25f) % textureWidth;
		
		leftTexturePositionIndex = (int) (cameraViewport.x / textureWidth);
		hillsLeft.setPosition((leftTexturePositionIndex - 1) * textureWidth + parallaxOffset, 0);
		hillsCenter.setPosition((leftTexturePositionIndex) * textureWidth + parallaxOffset, 0);
		hillsRight.setPosition((leftTexturePositionIndex + 1) * textureWidth + parallaxOffset, 0);
	}
	
	public void draw(SpriteBatch batch){
		for (Star s : starsArray) {
			s.draw(batch);
		}
		cloudsLeft.draw(batch);
		cloudsCenter.draw(batch);
		cloudsRight.draw(batch);
		hillsLeft.draw(batch);
		hillsCenter.draw(batch);
		hillsRight.draw(batch);
	}
	
	private void assignSprites(){
		cloudsLeft = new Sprite(StaticTextures.clouds);
		cloudsCenter = new Sprite(StaticTextures.clouds);
		cloudsRight = new Sprite(StaticTextures.clouds);
		cloudsLeft.setColor(0.1f, 0.1f, 0.4f, 1f);
		cloudsCenter.setColor(0.1f, 0.1f, 0.4f, 1f);
		cloudsRight.setColor(0.1f, 0.1f, 0.4f, 1f);
		hillsLeft = new Sprite(StaticTextures.hills);
		hillsCenter = new Sprite(StaticTextures.hills);
		hillsRight = new Sprite(StaticTextures.hills);
		hillsLeft.setColor(0, 0.4f, 0, 1f);
		hillsCenter.setColor(0, 0.4f, 0, 1f);
		hillsRight.setColor(0, 0.4f, 0, 1f);
	}
	
	private void generateStars() {
		for (int i = 0; i < 25; i++) {
			int randomSize = MathUtils.random(7, 14);
			int randomX = MathUtils.random(0, 800);
			int randomY = MathUtils.random(50, 480);
			star = new Star(randomSize, randomSize, randomX, randomY);
			starsArray.add(star);
		}
	}
}
