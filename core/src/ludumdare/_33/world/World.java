package ludumdare._33.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import ludumdare._33.MainGame;
import ludumdare._33.world.cat.Cat;
import ludumdare._33.world.environment.buildings.Building;
import ludumdare._33.world.environment.buildings.Home;
import ludumdare._33.world.environment.hidables.Foliage;
import ludumdare._33.world.human.Human;

public class World {

	public Cat cat;
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
		addPrey();
	}
	
	void addBuildings(){
		buildings.add(new Home(10));
		
		
	}
	
	void addFoliage(){
		
	}
	
	void addHumans(){
		humans.add(new Human(0));
	}
	
	void addPrey(){
		
	}

	float loseTimer = 0f;
	public void update(float delta) {
		cat.update(delta);
		for (Human h : humans) {
			h.update(delta);
			if(h.canSeeCat(cat) && cat.hasFood){
				loseTimer += delta;
				if(loseTimer > 0.4f){
					MainGame.instance.endGame();
				}
			}else{
				loseTimer -= delta;
				if(loseTimer < 0){
					loseTimer = 0;
				}
			}
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

}
