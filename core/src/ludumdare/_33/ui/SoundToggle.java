package ludumdare._33.ui;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.StaticTextures;
import ludumdare._33.sounds.SoundEffects;

public class SoundToggle extends UIOverlayItem {
	private boolean isMute;
	private static Vector2 size = new Vector2(52, 52);
	private static TextureRegion muteTexture = StaticTextures.soundMute;
	private static TextureRegion unmuteTexture = StaticTextures.soundUnmute;

	SoundEffects soundEffects;

	public SoundToggle(Vector2 position) {
		super(unmuteTexture, position, size);
		soundEffects = new SoundEffects();
		isMute = false;
	}

	public void toggle() {
		if (isMute) {
			super.changeTexture(unmuteTexture);
			// TODO: un-pause sound effects
			isMute = false;
		} else {
			super.changeTexture(muteTexture);
			// TODO: pause sound effects active
			isMute = true;
		}
	}

	@Override
	public void pressed() {
		toggle();
	}
}
