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
	
	protected Building(TextureRegion textureRegion, Vector2 position, Vector2 size, ArrayList<Rectangle> platforms) {
		this.textureRegion = textureRegion;
		this.position = position;
		this.size = size;
		for(Rectangle platform : platforms){
			platform.x += position.x;
			platform.y += position.y;
			Platforms.addPlatform(platform);
		}
	}
	
	public void draw(SpriteBatch batch){
		batch.draw(textureRegion, position.x, position.y, size.x, size.y);
	}
	
	public static boolean overlaps(Building b1, Building b2){
		Rectangle r1 = Rectangle.tmp;
		r1.x = b1.position.x;
		r1.y = b1.position.y;
		r1.width = b1.size.x;
		r1.height = b1.size.y;
		
		Rectangle r2 = Rectangle.tmp;
		r2.x = b2.position.x;
		r2.y = b2.position.y;
		r2.width = b2.size.x;
		r2.height = b2.size.y;
		
		return r1.overlaps(r2);
	}
	
}
