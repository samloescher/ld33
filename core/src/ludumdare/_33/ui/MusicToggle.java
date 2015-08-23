package ludumdare._33.ui;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.StaticTextures;

public class MusicToggle extends UIOverlayItem {
	private boolean isMute;
	private static Vector2 size = new Vector2(52, 52);
	private static TextureRegion muteTexture = StaticTextures.musicMute;
	private static TextureRegion unmuteTexture = StaticTextures.musicUnmute;

	public MusicToggle(Vector2 position) {
		super(unmuteTexture, position, size);
		isMute = false;
	}

	public void toggle() {
		if (isMute) {
			super.changeTexture(unmuteTexture);
			isMute = false;
		} else {
			super.changeTexture(muteTexture);
			isMute = true;
		}
	}

	@Override
	public void pressed() {
		toggle();
	}
}