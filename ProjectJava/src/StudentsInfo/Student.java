package StudentsInfo;

import Scores.Course;
import Scores.InfoOfTask;

import java.util.ArrayList;
import java.util.Objects;

public class Student extends Person {
    private final Integer idGroup;
    private Course course;
    private final String group;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public Student(Integer idGroup, String surname, String group) {
        super(surname);
        this.idGroup = idGroup;
        this.group = group;
    }

    public void addCourse(Course course) {
        this.course = course;
    }

    public String getFinalScores() {
        return ANSI_YELLOW + "Итог\n" + ANSI_RESET + "~Акт: " + course.getActivityScore() + " / " + this.course.getActivityMaxScore() + "\n~ Упр: " + this.course.getExScore() + " / " + this.course.getExercisesMaxScore() + "\n~ ДЗ: " + this.course.getHomeworkScore() + " / " + this.course.getHomeworkMaxScore() + "\n~ Сем: " + this.course.getSemScore() + " / " + this.course.getSeminarMaxScore();
    }

    public Float getAcScore(){
        return course.getActivityScore();
    }

    public Float getExScore(){
        return course.getExScore();
    }

    public Float getHomeScore(){
        return course.getHomeworkScore();
    }

    public Float getSemScore(){
        return course.getSemScore();
    }

    public String getResult() {
        var modules = course.getModules();
        var res = new StringBuilder();
        for(var i: modules)  res.append(i);
        return res.toString();
    }

    public String getGroup(){
        return group;
    }
    public Integer getIdGroup(){return idGroup;}
    public ArrayList<InfoOfTask> getModules() {
        return course.getModules();
    }

    public InfoOfTask getModule(String moduleName) {
        var modules = course.getModules();
        for(var i: modules){  if(Objects.equals(moduleName, i.getModuleName())) return i; }
        return null;
    }

    public String toString() {
        return ANSI_YELLOW + super.getSurnameName()  + " " + idGroup + " " + group + ANSI_RESET;
    }
}
