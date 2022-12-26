package Scores;

import java.util.ArrayList;

public class InfoOfTask {
    private final String taskName;
    private final float exMaxScore;
    private final float homeMaxScore;
    private final float acMaxScore;
    private final float acScore;
    private final float semMaxScore;
    private final float semScore;
    private final ArrayList<Task> exPoints = new ArrayList<>();
    private final ArrayList<Task> pracPoints = new ArrayList<>();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public InfoOfTask(String moduleName, float exMaxScore, float homeworkMaxScore, float acMaxScore, float semMaxScore, float acScore, float semScore) {
        this.taskName = moduleName;
        this.exMaxScore = exMaxScore;
        this.homeMaxScore = homeworkMaxScore;
        this.acMaxScore = acMaxScore;
        this.acScore = acScore;
        this.semMaxScore = semMaxScore;
        this.semScore = semScore;
    }

    public String getModuleName() {
        return this.taskName;
    }

    public float getExMaxScore() {
        return this.exMaxScore;
    }

    public float getHomeMaxScore() {
        return this.homeMaxScore;
    }

    public float getAcMaxScore() {
        return this.acMaxScore;
    }

    public float getAcScore() {
        return this.acScore;
    }

    public float getHomeScore() {
        float sc = 0f;
        for(var i: pracPoints) sc += i.getPoints();
        return sc;
    }

    public float getExScore() {
        float sc = 0f;
        for(var i: exPoints) sc += i.getPoints();
        return sc;
    }

    public float getSemScore() {
        return this.semScore;
    }

    public float getSemMaxScore() {
        return this.semMaxScore;
    }

    public ArrayList<Task> getExercises() {
        return this.exPoints;
    }

    public ArrayList<Task> getHomeworks() {
        return this.pracPoints;
    }

    public void addExercise(Task task) {
        this.exPoints.add(task);
    }

    public void addHomework(Task task) {
        this.pracPoints.add(task);
    }

    public String getResult() {
        var conclusion = new StringBuilder();
        conclusion.append("Модуль: ").append(this.getModuleName());

        for(var i: exPoints){
            var result = "\n~ " + i.getTaskName() + "  " + i.getPoints() + " / " + i.getScoreMax();
            conclusion.append(result);
        }

        for(var i: pracPoints){
            var result = "\n~ " + i.getTaskName() + "  " + i.getPoints() + " из " + i.getScoreMax();
            conclusion.append(result);
        }
        return conclusion.toString();
    }

    public String toString() {
        return ANSI_YELLOW + "Модуль: " + getModuleName() +ANSI_RESET + "\n~ Акт: " + getAcScore() + " / " + getAcMaxScore() + "\n~ Упр: " + getExScore() + " / " + getExMaxScore() + "\n~ ДЗ: " + getHomeScore() + " / " + getHomeMaxScore() + "\n~ Сем: " + getAcScore() + " / " + getAcMaxScore() + "\n\n";
    }
}
