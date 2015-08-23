package ludumdare._33.world.environment.buildings;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.StaticTextures;

public class Church extends Building {

	private static ArrayList<Rectangle> platforms;
	private static Vector2 size = new Vector2(620, 540);

	static {
		platforms = new ArrayList<Rectangle>();
		platforms.add(new Rectangle(size.x / 400f, size.y / 2.5f, size.x / 1.38f, size.y / 5.1f));
		platforms.add(new Rectangle(size.x / 1.39f, size.y / 1.45f, size.x / 3.6f, size.y / 4.2f));
	}

	public Church(Vector2 position) {
		super(StaticTextures.church, position, size, platforms);
	}

}
