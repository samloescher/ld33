package ludumdare._33.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {
	
	Cat cat;
	ArrayList<Human> humans = new ArrayList<Human>();
	
	public World(){
		cat = new Cat();
		//humans.add(new Human(50));
	}
	
	public void update(float delta){
		cat.update(delta);
		for(Human h : humans){
			h.update(delta);
		}
	}
	
	public void draw(SpriteBatch batch){
		cat.draw(batch);
		for(Human h : humans){
			h.draw(batch);
		}
	}

}
