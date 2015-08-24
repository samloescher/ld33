package ludumdare._33.world.environment.buildings;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.StaticTextures;

public class Home extends Building {

	private ArrayList<Rectangle> platforms;
	private static Vector2 size = new Vector2(400, 300);

	public Home(float x) {
		super(StaticTextures.home, new Vector2(x, 0), size);
		platforms = new ArrayList<Rectangle>();
		platforms.add(new Rectangle(size.x / 200f, size.y / 1.6f, size.x / 1.06f, size.y / 2.7f));
		addPlatforms(platforms);

	}

}
