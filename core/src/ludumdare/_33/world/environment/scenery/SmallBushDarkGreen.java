package ludumdare._33.world.environment.scenery;

import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.StaticTextures;

public class SmallBushDarkGreen extends Foliage {
	private static Vector2 size = new Vector2(80, 60);

	public SmallBushDarkGreen(Vector2 position) {
		super(StaticTextures.SmallBushDarkGreen, position, size);
	}
}
