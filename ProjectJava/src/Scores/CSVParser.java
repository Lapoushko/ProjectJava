package Scores;

import StudentsInfo.Student;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CSVParser {
    ArrayList<Student> studentsGroup = new ArrayList<>();
    ArrayList<String> groups = new ArrayList<>();
    ArrayList<String> students = new ArrayList<>();
    String[] typeTasks;
    String[] maxScore;
    String[] listTasks;

    public CSVParser() throws IOException {
        var path = Path.of("C:\\Users\\vadim\\IdeaProjects\\ProjectJava\\src\\basicprogramming_2.csv");
        var lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        var data = lines.stream().map(line ->line.split(";", -1)).toList();
        listTasks = data.get(0);
        typeTasks = data.get(1);
        maxScore = data.get(2);
        createNewStudents(data);
    }


    private InfoOfTask addNewTask(InfoOfTask infoOfTask, String[] scores, String[] mScores, String[] names) {
        for(var i = 0; i < scores.length; ++i) {
            var ms = Float.parseFloat(mScores[i]);
            var ps = Float.parseFloat(scores[i]);
            if (names[i].startsWith("Упр:")) {
                infoOfTask.addExercise(new Task(names[i], ms, ps));
            } else if (names[i].startsWith("ДЗ:")) {
                infoOfTask.addHomework(new Task(names[i], ms, ps));
            }
        }

        return infoOfTask;
    }

    private static int finding(String[] a, String elem) {
        for(int i = 0; i < a.length; ++i) {
            if (Objects.equals(a[i], elem)) {
                return i;
            }
        }

        return -1;
    }

    private void createNewStudents(List<String[]> lines) {
        var count = 1;
        for(int i = 4; i < lines.size(); i++){
            if (Objects.equals(lines.get(i)[1], lines.get(i-1)[1]))
                studentsGroup.add(createNewCourse(new Student(count, lines.get(i - 1)[0], lines.get(i - 1)[1]), lines.get(i - 1)));
            else {
                studentsGroup.add(createNewCourse(new Student(count, lines.get(i - 1)[0], lines.get(i - 1)[1]), lines.get(i - 1)));
                count += 1;
            }
            groups.add(lines.get(i - 1)[1]);
            students.add(lines.get(i - 1)[0]);
        }
        studentsGroup.add(createNewCourse(new Student(count, lines.get(lines.size() - 1)[0], lines.get(lines.size() - 1)[1]), lines.get(lines.size() - 1)));
        groups.add(lines.get(lines.size() - 1)[1]);
        students.add(lines.get(lines.size() - 1)[0]);

    }

    private Student createNewCourse(Student student, String[] info) {
        var act = Float.parseFloat(this.maxScore[2]);
        var ex = Float.parseFloat(this.maxScore[3]);
        var prac = Float.parseFloat(this.maxScore[4]);
        var sem = Float.parseFloat(this.maxScore[5]);
        var stScores = new Course(act, ex, prac, sem);
        InfoOfTask infoOfTask = null;
        var count = 8;

        while(count < info.length) {
            var titles = (String[])Arrays.copyOfRange(this.typeTasks, count, this.typeTasks.length);
            var md = (String[])Arrays.copyOfRange(info, count, Arrays.asList(titles).indexOf("Сем") + count + 1);
            var hw = (String[])Arrays.copyOfRange(this.typeTasks, count, Arrays.asList(titles).indexOf("Сем") + count + 1);
            var mScore = (String[])Arrays.copyOfRange(this.maxScore, count, Arrays.asList(titles).indexOf("Сем") + count + 1);
            var hMaxScore = finding(hw, "ДЗ") != -1 ? this.maxScore[finding(hw, "ДЗ") + count] : "0";
            var exMaxScore = Float.parseFloat(this.maxScore[count + 1]);
            var homeMaxScore = Float.parseFloat(hMaxScore);
            var acMaxScore = Float.parseFloat(this.maxScore[count]);
            var acScore = Float.parseFloat(this.maxScore[count + md.length - 1]);
            var semMaxScore = Float.parseFloat(md[0]);
            var semScore = Float.parseFloat(md[md.length - 1]);
            infoOfTask = new InfoOfTask(listTasks[count], exMaxScore, homeMaxScore, acMaxScore, acScore, semMaxScore, semScore);
            count = Arrays.asList(titles).indexOf("Сем") + count + 1;
            stScores.addModule(addNewTask(infoOfTask, md, mScore, hw));
        }

        student.addCourse(stScores);
        return student;
    }

    public ArrayList<Student> getStudentsGroup() {
        return studentsGroup;
    }
    public ArrayList<String> getGroups(){return groups;}
    public ArrayList<String> getStudents(){return students;}
}
