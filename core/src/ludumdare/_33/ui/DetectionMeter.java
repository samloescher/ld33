package ludumdare._33.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class DetectionMeter {
	
	float detectionLevel;
	Color color;
	Rectangle bounds;
	
	public DetectionMeter(){
		bounds = new Rectangle(700,40,50,400);
	}
	
	public void setDetectionLevel(float percent){
		if(percent > 1){
			percent = 1;
		}
		detectionLevel = percent;
	}
	
	public void draw(ShapeRenderer renderer){
		if(detectionLevel > 0.7f){
			color = Color.RED;
		}else if(detectionLevel > 0.2){
			color = Color.ORANGE;
		}else{
			color = Color.GREEN;
		}
		
		renderer.begin(ShapeType.Filled);
		renderer.setColor(Color.WHITE);
		renderer.rect(bounds.x-2, bounds.y-2, bounds.width+4, bounds.height+4);
		renderer.setColor(Color.BLACK);
		renderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
		renderer.setColor(color);
		renderer.rect(bounds.x, bounds.y, bounds.width, bounds.height * detectionLevel);
		renderer.end();
	}

}
