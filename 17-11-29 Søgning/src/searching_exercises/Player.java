package searching_exercises;

public class Player {
	private String name;
	private int height;
	private int weight;
	private int score;

	public Player(String name, int height, int weight, int score) {
		this.height = height;
		this.name = name;
		this.weight = weight;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	public int getScore() {
		return score;
	}
	
	@Override
    public String toString(){
		return "Name: " + name + " height: " + height + " weight: " + weight + " goals: " + score;
	}

}
