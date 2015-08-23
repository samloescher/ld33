package ludumdare._33.world.environment.hidables;

import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.StaticTextures;

public class TreeBrown extends Foliage {
	private static Vector2 size = new Vector2(80, 155);

	public TreeBrown(Vector2 position) {
		super(StaticTextures.treeBrown, position, size);
	}
}
