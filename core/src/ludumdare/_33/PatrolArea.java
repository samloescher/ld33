package ludumdare._33;

public class PatrolArea {

	float min, max;

	public PatrolArea(float x1, float x2) {
		min = x1;
		max = x2;
	}

	public boolean isRightOfBounds(float x){
		return x > max;
	}
	
	public boolean isLeftOfBounds(float x){
		return x<min;
	}

}
