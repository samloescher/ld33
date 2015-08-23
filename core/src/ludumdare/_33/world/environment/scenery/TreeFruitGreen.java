package ludumdare._33.world.environment.scenery;

import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.StaticTextures;

public class TreeFruitGreen extends Foliage {
	private static Vector2 size = new Vector2(80, 155);

	public TreeFruitGreen(Vector2 position) {
		super(StaticTextures.TreeFruitGreen, position, size);
	}
}
