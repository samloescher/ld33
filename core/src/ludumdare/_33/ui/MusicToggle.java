package ludumdare._33.ui;

import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.StaticTextures;

public class MusicToggle extends UIOverlayItem {
	private static Vector2 size = new Vector2(52, 52);

	public MusicToggle(Vector2 position) {
		super(StaticTextures.MusicUnmute, position, size);
	}
}
