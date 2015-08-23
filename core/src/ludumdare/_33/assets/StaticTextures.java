package ludumdare._33.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StaticTextures {

	public static TextureRegion Home;
	public static TextureRegion Church;
	public static TextureRegion Marketplace;
	public static TextureRegion Bungalow1;
	public static TextureRegion Bungalow2;

	public static TextureRegion HedgeGreen;
	public static TextureRegion SmallBushDarkGreen;
	public static TextureRegion SmallBushGreen;
	public static TextureRegion SmallBushFruitGreen;
	public static TextureRegion SmallTreeGreen;
	public static TextureRegion TreeBrown;
	public static TextureRegion TreeGreen;
	public static TextureRegion TreeFruitGreen;

	static {
		loadAllTextures();
	}

	public static void loadAllTextures() {
		/* Buildings */
		Home = new TextureRegion(new Texture("images/buildings/houses/home.png"));
		Church = new TextureRegion(new Texture("images/buildings/houses/church.png"));
		Marketplace = new TextureRegion(new Texture("images/buildings/houses/marketplace.png"));
		Bungalow1 = new TextureRegion(new Texture("images/buildings/houses/bungalow-1.png"));
		Bungalow2 = new TextureRegion(new Texture("images/buildings/houses/bungalow-2.png"));

		/* Scenery */
		HedgeGreen = new TextureRegion(new Texture("images/buildings/scenery/hedge-green.png"));
		SmallBushDarkGreen = new TextureRegion(new Texture("images/buildings/scenery/small-bush-darkgreen.png"));
		SmallBushGreen = new TextureRegion(new Texture("images/buildings/scenery/small-bush-green.png"));
		SmallBushFruitGreen = new TextureRegion(new Texture("images/buildings/scenery/small-bush-fruit-green.png"));
		SmallTreeGreen = new TextureRegion(new Texture("images/buildings/scenery/small-tree-green.png"));
		TreeBrown = new TextureRegion(new Texture("images/buildings/scenery/tree-brown.png"));
		TreeGreen = new TextureRegion(new Texture("images/buildings/scenery/tree-green.png"));
		TreeFruitGreen = new TextureRegion(new Texture("images/buildings/scenery/tree-fruit-green.png"));
	}
}
