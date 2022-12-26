package Scores;

public class Task {
    private final String taskName;
    private final float scoreMax;
    private final float points;

    public Task(String taskName, float scoreMax, float points) {
        this.taskName = taskName;
        this.scoreMax = scoreMax;
        this.points = points;
    }

    public String getTaskName() {
        return taskName;
    }

    public float getScoreMax() {
        return scoreMax;
    }

    public float getPoints() {
        return points;
    }
}
