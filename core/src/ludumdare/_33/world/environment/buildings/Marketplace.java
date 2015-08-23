package ludumdare._33.world.environment.buildings;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.StaticTextures;

public class Marketplace extends Building {
	private static ArrayList<Rectangle> platforms;
	private static Vector2 size = new Vector2(550, 280);

	static {
		platforms = new ArrayList<Rectangle>();
		platforms.add(new Rectangle(size.x / 400f, size.y / 1.43f, size.x / 1.15f, size.y / 3.5f));
	}

	public Marketplace(Vector2 position) {
		super(StaticTextures.Marketplace, position, size, platforms);
	}
}
