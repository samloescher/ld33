package ludumdare._33.world.prey;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PreyManager {
	
	ArrayList<Prey> preys = new ArrayList<Prey>();
	
	public void update(float delta){
		if(preys.size() < 15){
			spawnRandomPrey();
		}
		
		for(Prey prey : preys){
			prey.update(delta);
		}
	}
	
	void spawnRandomPrey(){
		
	}
	
	public void draw(SpriteBatch batch){
		for(Prey prey : preys){
			prey.draw(batch);
		}
	}

}
