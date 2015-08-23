package ludumdare._33.world.environment.buildings;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.Assets.StaticTextures;

public class Church extends Building {

	private static ArrayList<Rectangle> platforms;
	private static Vector2 size = new Vector2(500, 400);

	static {
		platforms = new ArrayList<Rectangle>();
		platforms.add(new Rectangle(size.x / 64f, size.y / 2.5f, size.x / 1.4f, size.y / 5f));
		platforms.add(new Rectangle(size.x / 1.4f, size.y / 1.45f, size.x / 3.6f, size.y / 4.2f));
	}

	public Church(Vector2 position) {
		super(StaticTextures.Church, position, size, platforms);
	}

}
