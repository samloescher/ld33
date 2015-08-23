package ludumdare._33.world.environment.buildings;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.Assets.StaticTextures;

public class Home extends Building {

	private static ArrayList<Rectangle> platforms;
	private static Vector2 size = new Vector2(400, 300);

	static {
		platforms = new ArrayList<Rectangle>();
		platforms.add(new Rectangle(size.x / 200f, size.y / 1.6f, size.x / 1.06f, size.y / 2.7f));
	}

	public Home(Vector2 position) {
		super(StaticTextures.Home, position, size, platforms);
	}

}
