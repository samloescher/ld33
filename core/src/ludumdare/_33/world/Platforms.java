package ludumdare._33.world;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;

public class Platforms {
	
	ArrayList<Rectangle> platforms = new ArrayList<Rectangle>();
	
	void addPlatform(Rectangle platform){
		platforms.add(platform);
	}
	
	boolean collidingWithPlatform(Rectangle collidable){
		for(Rectangle platform : platforms){
			if (collidable.overlaps(platform)){
				return true;
			}
		}
		
		return false;
	}

}
