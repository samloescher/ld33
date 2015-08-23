package ludumdare._33.world.environment.buildings;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.StaticTextures;

public class Bungalow2 extends Building {
	private static ArrayList<Rectangle> platforms;
	private static Vector2 size = new Vector2(270, 250);

	static {
		platforms = new ArrayList<Rectangle>();
		platforms.add(new Rectangle(size.x / 200f, size.y / 1.88f, size.x / 1.01f, size.y / 2.9f));
	}

	public Bungalow2(Vector2 position) {
		super(StaticTextures.bungalow2, position, size, platforms);
	}
}
