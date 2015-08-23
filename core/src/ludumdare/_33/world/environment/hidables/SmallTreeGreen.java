package ludumdare._33.world.environment.hidables;

import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.StaticTextures;

public class SmallTreeGreen extends Foliage {
	private static Vector2 size = new Vector2(80, 75);

	public SmallTreeGreen(Vector2 position) {
		super(StaticTextures.SmallTreeGreen, position, size);
	}
}
