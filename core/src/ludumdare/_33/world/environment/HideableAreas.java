package ludumdare._33.world.environment;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class HideableAreas {

	public static ArrayList<Rectangle> bushes = new ArrayList<Rectangle>();
	
	public static void addPlatform(Rectangle platform){
		bushes.add(platform);
	}
	
	public static boolean collidingWithBush(Rectangle collidable){
		for(Rectangle platform : bushes){
			if (collidable.overlaps(platform)){
				return true;
			}
		}
		
		return false;
	}

	public static void draw(ShapeRenderer shapeRenderer){
		shapeRenderer.begin(ShapeType.Line);
		for(Rectangle rect : bushes){
			shapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);
		}
		shapeRenderer.end();
	}
}
