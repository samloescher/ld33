package ludumdare._33.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.world.cat.Cat;
import ludumdare._33.world.environment.Foliage;
import ludumdare._33.world.environment.buildings.Building;
import ludumdare._33.world.environment.buildings.Bungalow1;
import ludumdare._33.world.environment.buildings.Bungalow2;
import ludumdare._33.world.environment.buildings.Church;
import ludumdare._33.world.environment.buildings.Home;
import ludumdare._33.world.environment.buildings.Marketplace;

public class World {

	Cat cat;
	ArrayList<Human> humans = new ArrayList<Human>();
	ArrayList<Building> buildings = new ArrayList<Building>();
	ArrayList<Foliage> foliage = new ArrayList<Foliage>();
	TextureRegion backdrop;

	public static Rectangle bounds = new Rectangle(0, 0, 800 * 5, 480f * 1.5f);

	public World() {
		cat = new Cat();

		buildings.add(new Home(new Vector2(150, 0)));
		buildings.add(new Church(new Vector2(600, 0)));
		buildings.add(new Marketplace(new Vector2(1200, 0)));
		buildings.add(new Bungalow1(new Vector2(2000, 0)));
		buildings.add(new Bungalow2(new Vector2(2500, 0)));
		// humans.add(new Human(50));
	}

	public void update(float delta) {
		cat.update(delta);
		for (Human h : humans) {
			h.update(delta);
		}
	}

	public void draw(SpriteBatch batch) {
		
		for (Building b : buildings) {
			b.draw(batch);
		}

		for (Human h : humans) {
			h.draw(batch);
		}

		cat.draw(batch);
	}
	
	public void drawDebug(ShapeRenderer shapeRenderer) {
		cat.drawFloorCheck(shapeRenderer);
	}

	public Vector2 getCatPosition() {
		return new Vector2(cat.position).add(cat.width / 2, cat.height / 2);
	}

}
