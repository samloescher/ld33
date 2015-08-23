package ludumdare._33.Assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StaticTextures {
	
	public static TextureRegion Home;
	
	static{
		loadAllTextures();
	}
	
	public static void loadAllTextures() {
		Home = new TextureRegion(new Texture("images/buildings/houses/home.png"));
		//TODO : new CHURCH TEXTURE
	}
	
}
