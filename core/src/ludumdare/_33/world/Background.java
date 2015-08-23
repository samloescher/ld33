package ludumdare._33.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import ludumdare._33.assets.StaticTextures;

public class Background {
	Sprite cloudsLeft;
	Sprite cloudsRight;
	
	Sprite hillsLeft;
	Sprite hillsRight;
	
	Rectangle cameraViewport = new Rectangle();
	OrthographicCamera camera;
	
	public Background(OrthographicCamera camera) {
		this.camera = camera;
		assignSprites();
	}
	
	public void update(){
		updateCameraViewportBounds();
		adjustTexturePositionsToCoverScreen();
	}
	
	void updateCameraViewportBounds(){
		cameraViewport.x = camera.position.x - camera.viewportWidth/2;
		cameraViewport.y = camera.position.y - camera.viewportHeight/2;
		cameraViewport.width = camera.viewportWidth;
		cameraViewport.height = camera.viewportHeight;
	}
	
	void adjustTexturePositionsToCoverScreen(){
		int textureWidths;
		
		textureWidths = (int) (cameraViewport.x  / cloudsLeft.getWidth());
		cloudsLeft.setPosition((textureWidths) * cloudsLeft.getWidth(), 40);
		cloudsRight.setPosition((textureWidths + 1) * cloudsRight.getWidth(), 40);
		
		textureWidths = (int) (cameraViewport.x / hillsLeft.getWidth());
		hillsLeft.setPosition((textureWidths) * hillsLeft.getWidth(), 0);
		hillsRight.setPosition((textureWidths + 1) * hillsRight.getWidth(), 0);
	}
	
	public void draw(SpriteBatch batch){
		cloudsLeft.draw(batch);
		cloudsRight.draw(batch);
		hillsLeft.draw(batch);
		hillsRight.draw(batch);
	}
	
	void assignSprites(){
		cloudsLeft = new Sprite(StaticTextures.Clouds);
		cloudsRight = new Sprite(StaticTextures.Clouds);
		cloudsLeft.setColor(0.2f, 0.2f, 0.5f, 1f);
		cloudsRight.setColor(0.2f, 0.2f, 0.5f, 1f);
		hillsLeft = new Sprite(StaticTextures.Hills);
		hillsRight = new Sprite(StaticTextures.Hills);
		hillsLeft.setColor(0, 0.6f, 0, 1f);
		hillsRight.setColor(0, 0.6f, 0, 1f);
	}
	
}
