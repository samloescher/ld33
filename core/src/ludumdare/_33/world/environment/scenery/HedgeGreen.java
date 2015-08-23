package ludumdare._33.world.environment.scenery;

import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.StaticTextures;

public class HedgeGreen extends Foliage {
	private static Vector2 size = new Vector2(80, 75);

	public HedgeGreen(Vector2 position) {
		super(StaticTextures.HedgeGreen, position, size);
	}
}
