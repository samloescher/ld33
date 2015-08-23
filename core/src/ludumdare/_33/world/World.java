package ludumdare._33.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.world.cat.Cat;
import ludumdare._33.world.environment.buildings.Building;
import ludumdare._33.world.environment.buildings.Home;
import ludumdare._33.world.environment.hidables.Foliage;
import ludumdare._33.world.human.Human;

public class World {

	Cat cat;
	ArrayList<Human> humans = new ArrayList<Human>();
	ArrayList<Building> buildings = new ArrayList<Building>();
	ArrayList<Foliage> foliage = new ArrayList<Foliage>();

	public static Rectangle bounds = new Rectangle(0, 0, 800f * 10f, 480f * 3f);

	public World() {
		cat = new Cat();
		
		generateWorld();
	}
	
	void generateWorld(){
		addBuildings();
		addFoliage();
		addHumans();
	}
	
	void addBuildings(){
		buildings.add(new Home(10));
		
		
	}
	
	void addFoliage(){
		
	}
	
	void addHumans(){
		humans.add(new Human(0));
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

		cat.draw(batch);

		for (Foliage f : foliage) {
			f.draw(batch);
		}
		
		for (Human h : humans) {
			h.draw(batch);
		}
	}

	public void drawDebug(ShapeRenderer shapeRenderer) {
		cat.drawFloorCheck(shapeRenderer);
		for (Human h : humans) {
			h.drawDebug(shapeRenderer);
		}
	}

	public Vector2 getCatPosition() {
		return new Vector2(cat.position).add(cat.width / 2, cat.height / 2);
	}

}
