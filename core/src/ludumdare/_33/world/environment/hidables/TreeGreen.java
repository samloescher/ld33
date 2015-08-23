package ludumdare._33.world.environment.hidables;

import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.StaticTextures;

public class TreeGreen extends Foliage {
	private static Vector2 size = new Vector2(80, 155);

	public TreeGreen(Vector2 position) {
		super(StaticTextures.treeGreen, position, size);
	}
}
