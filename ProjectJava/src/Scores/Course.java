package Scores;

import java.util.ArrayList;

public class Course {
    private final ArrayList<InfoOfTask> InfoOfTasks = new ArrayList<>();
    private final float totalActivities;
    private final float totalExercises;
    private final float totalPractices;
    private final float totalSem;

    public Course(float actMaxScore, float exMaxScore, float pracMaxScore, float semMaxScore) {
        this.totalActivities = actMaxScore;
        this.totalExercises = exMaxScore;
        this.totalPractices = pracMaxScore;
        this.totalSem = semMaxScore;
    }

    public void addModule(InfoOfTask infoOfTask) {
        InfoOfTasks.add(infoOfTask);
    }

    public float getExercisesMaxScore() {
        return totalExercises;
    }

    public float getHomeworkMaxScore() {
        return totalPractices;
    }

    public float getActivityMaxScore() {
        return totalActivities;
    }

    public float getSeminarMaxScore() {
        return totalSem;
    }

    public ArrayList<InfoOfTask> getModules() {
        return InfoOfTasks;
    }

    public float getExScore() {
        float sc = 0f;
        for(var i: InfoOfTasks) sc += i.getExScore();
        return sc;
    }

    public float getHomeworkScore() {
        float sc = 0f;
        for(var i: InfoOfTasks) sc += i.getHomeScore();
        return sc;
    }

    public float getActivityScore() {
        float sc = 0f;
        for(var i: InfoOfTasks) sc += i.getAcScore();
        return sc;
    }

    public float getSemScore() {
        float sc = 0f;
        for(var i: InfoOfTasks) sc += i.getSemScore();
        return sc;
    }
}
