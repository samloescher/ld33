package ludumdare._33.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StaticTextures {

	public static TextureRegion home;
	public static TextureRegion church;
	public static TextureRegion marketplace;
	public static TextureRegion bungalow1;
	public static TextureRegion bungalow2;

	public static TextureRegion hedgeGreen;
	public static TextureRegion smallBushDarkGreen;
	public static TextureRegion smallBushGreen;
	public static TextureRegion smallBushFruitGreen;
	public static TextureRegion smallTreeGreen;
	public static TextureRegion treeBrown;
	public static TextureRegion treeGreen;
	public static TextureRegion treeFruitGreen;
	
	public static TextureRegion clouds;
	public static TextureRegion hills;
	
	public static TextureRegion soundMute;
	public static TextureRegion soundUnmute;
	public static TextureRegion musicMute;
	public static TextureRegion musicUnmute;

	static {
		loadAllTextures();
	}

	public static void loadAllTextures() {
		/* Buildings */
		home = new TextureRegion(new Texture("images/buildings/houses/home.png"));
		church = new TextureRegion(new Texture("images/buildings/houses/church.png"));
		marketplace = new TextureRegion(new Texture("images/buildings/houses/marketplace.png"));
		bungalow1 = new TextureRegion(new Texture("images/buildings/houses/bungalow-1.png"));
		bungalow2 = new TextureRegion(new Texture("images/buildings/houses/bungalow-2.png"));

		/* Scenery */
		hedgeGreen = new TextureRegion(new Texture("images/buildings/scenery/hedge-green.png"));
		smallBushDarkGreen = new TextureRegion(new Texture("images/buildings/scenery/small-bush-darkgreen.png"));
		smallBushGreen = new TextureRegion(new Texture("images/buildings/scenery/small-bush-green.png"));
		smallBushFruitGreen = new TextureRegion(new Texture("images/buildings/scenery/small-bush-fruit-green.png"));
		smallTreeGreen = new TextureRegion(new Texture("images/buildings/scenery/small-tree-green.png"));
		treeBrown = new TextureRegion(new Texture("images/buildings/scenery/tree-brown.png"));
		treeGreen = new TextureRegion(new Texture("images/buildings/scenery/tree-green.png"));
		treeFruitGreen = new TextureRegion(new Texture("images/buildings/scenery/tree-fruit-green.png"));
		
		clouds = new TextureRegion(new Texture("images/background/clouds.png"));
		hills = new TextureRegion(new Texture("images/background/hills.png"));
		
		/* Sound */
		soundMute = new TextureRegion(new Texture("images/sound-toggle/sound-mute.png"));
		soundUnmute = new TextureRegion(new Texture("images/sound-toggle/sound-unmute.png"));
		musicMute = new TextureRegion(new Texture("images/sound-toggle/music-mute.png"));
		musicUnmute = new TextureRegion(new Texture("images/sound-toggle/music-unmute.png"));
	}
}
