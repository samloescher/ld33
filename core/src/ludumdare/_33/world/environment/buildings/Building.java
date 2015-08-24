package ludumdare._33.world.environment.buildings;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.world.environment.Platforms;

public class Building {
	
	TextureRegion textureRegion;
	Vector2 position;
	Vector2 size;
	
	protected Building(TextureRegion textureRegion, Vector2 position, Vector2 size) {
		this.textureRegion = textureRegion;
		this.position = position;
		this.size = size;
		
	}
	
	public void draw(SpriteBatch batch) {
		batch.draw(textureRegion, position.x, position.y, size.x, size.y);
	}

	void addPlatforms(ArrayList<Rectangle> platforms) {
		for (Rectangle platform : platforms) {
			platform.x += position.x;
			platform.y += position.y;
			Platforms.addPlatform(platform);
		}
	}
}
