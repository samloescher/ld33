package ludumdare._33.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class Platforms {
	
	public static ArrayList<Rectangle> platforms = new ArrayList<Rectangle>();
	
	public static void addPlatform(Rectangle platform){
		platforms.add(platform);
	}
	
	public static boolean collidingWithPlatform(Rectangle collidable){
		for(Rectangle platform : platforms){
			if (collidable.overlaps(platform)){
				return true;
			}
		}
		
		return false;
	}

	public static void draw(ShapeRenderer shapeRenderer){
		shapeRenderer.begin(ShapeType.Line);
		for(Rectangle rect : platforms){
			shapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);
		}
		shapeRenderer.end();
	}
}
