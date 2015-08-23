package ludumdare._33.world.environment;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.Assets.StaticTextures;

public class Home extends Building{
	
	private static ArrayList<Rectangle> platforms;
	
	static{
		platforms = new ArrayList<Rectangle>();
		platforms.add(new Rectangle(5,150,290,80));
	}
	
	public Home(Vector2 position){
		super(StaticTextures.Home, position, new Vector2(320,240), platforms);
	}
	
}
