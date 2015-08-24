package ludumdare._33.ui;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.StaticTextures;
import ludumdare._33.screens.GameScreen;
import ludumdare._33.sounds.SoundEffects;

class SoundToggle extends UIOverlayItem {
	private boolean isMute;
	private static Vector2 size = new Vector2(17, 17);
	private static TextureRegion muteTexture = StaticTextures.soundMute;
	private static TextureRegion unmuteTexture = StaticTextures.soundUnmute;
	
	SoundEffects soundEffects;

	SoundToggle(Vector2 position) {
		super(unmuteTexture, position, size);
		soundEffects = GameScreen.soundEffects;
		isMute = false;
	}

	private void toggle() {
		if (isMute) {
			super.changeTexture(unmuteTexture);
			soundEffects.volume = 1f;
			isMute = false;
		} else {
			super.changeTexture(muteTexture);
			soundEffects.volume = 0;
			soundEffects.stopAllSounds();
			isMute = true;
		}
	}

	@Override
	public void pressed() {
		toggle();
	}
}
