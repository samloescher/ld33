package ludumdare._33.ui;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.StaticTextures;
import ludumdare._33.sounds.Jukebox;

class MusicToggle extends UIOverlayItem {
	private static boolean isMute;
	private static Vector2 size = new Vector2(17, 17);
	private static TextureRegion muteTexture = StaticTextures.musicMute;
	private static TextureRegion unmuteTexture = StaticTextures.musicUnmute;


	MusicToggle(Vector2 position) {
		super(unmuteTexture, position, size);
		Jukebox.play();
		if(Jukebox.getVolume() == 0){
			super.changeTexture(muteTexture);
		}
	}

	private void toggle() {
		if (isMute) {
			super.changeTexture(unmuteTexture);
			Jukebox.play();
			isMute = false;
			Jukebox.setVolume(1);
		} else {
			super.changeTexture(muteTexture);
			Jukebox.pause();
			isMute = true;
			Jukebox.setVolume(0);
		}
	}

	@Override
	public void pressed() {
		toggle();
	}
}