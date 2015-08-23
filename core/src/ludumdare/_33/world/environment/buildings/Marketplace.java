package ludumdare._33.world.environment.buildings;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.Assets.StaticTextures;

public class Marketplace extends Building {
	private static ArrayList<Rectangle> platforms;
	private static Vector2 size = new Vector2(500, 160);

	static {
		platforms = new ArrayList<Rectangle>();
		platforms.add(new Rectangle(size.x / 400f, size.y / 1.43f, size.x / 1.12f, size.y / 3.3f));
	}

	public Marketplace(Vector2 position) {
		super(StaticTextures.Marketplace, position, size, platforms);
	}
}
