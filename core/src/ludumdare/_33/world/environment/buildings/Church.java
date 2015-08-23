package ludumdare._33.world.environment.buildings;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.Assets.StaticTextures;

public class Church extends Building{
	
	private static ArrayList<Rectangle> platforms;
	private static Vector2 size = new Vector2(400,300); //320, 240
	//TODO SET SIZE
	static{
		platforms = new ArrayList<Rectangle>();
		//TODO : platforms.add(new Rectangle(size.x/64f,size.y/1.6f,size.x/1.1f,size.y/3f));
		// And another..
	}
	
	public Church(Vector2 position){
		super(StaticTextures.Home, position, size, platforms);
	}
	
}
