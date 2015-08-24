package ludumdare._33;

public class PatrolArea {

	float min, max;

	public PatrolArea(float x1, float x2) {
		min = x1;
		max = x2;
	}

	public boolean isInsideBounds(float x) {
		if (x < min || x > max) {
			return false;
		}
		return true;
	}

}
