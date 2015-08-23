package ludumdare._33.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StaticTextures {

	public static TextureRegion Home;
	public static TextureRegion Church;
	public static TextureRegion Marketplace;
	public static TextureRegion Bungalow1;
	public static TextureRegion Bungalow2;

	static {
		loadAllTextures();
	}

	public static void loadAllTextures() {
		Home = new TextureRegion(new Texture("images/buildings/houses/home.png"));
		Church = new TextureRegion(new Texture("images/buildings/houses/church.png"));
		Marketplace = new TextureRegion(new Texture("images/buildings/houses/marketplace.png"));
		Bungalow1 = new TextureRegion(new Texture("images/buildings/houses/bungalow-1.png"));
		Bungalow2 = new TextureRegion(new Texture("images/buildings/houses/bungalow-2.png"));
	}

}
