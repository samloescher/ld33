package ludumdare._33.world.human;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

class DetectionTriangle {
	
	Vector2 t1,t2 = new Vector2(),t3 = new Vector2();
	
	boolean facingRight;
	
	boolean canSeeCat(Vector2 catPosition){
		return Intersector.isPointInTriangle(catPosition.x, catPosition.y,
				t1.x, t1.y, t2.x, t2.y, t3.x, t3.y);
	}
	
	void update( Vector2 eyePosition, boolean facingRight){
		this.facingRight = facingRight;
		updateArea(eyePosition);
	}
	
	private void updateArea(Vector2 eyePosition){
		t1 = eyePosition.cpy();
		if(facingRight){
			t1.x = t1.x + 20;
			
			t2.x = t1.x + 350;
			t2.y = t1.y - 200;
			
			t3.x = t2.x ;
			t3.y = t2.y + 400;
		}else{
			t2.x = t1.x - 350;
			t2.y = t1.y - 200;
			
			t3.x = t2.x ;
			t3.y = t2.y + 400;
		}
	}
	
	void draw(ShapeRenderer shapeRenderer){
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.triangle(t1.x, t1.y, t2.x, t2.y, t3.x, t3.y);
		shapeRenderer.end();
	}

}
