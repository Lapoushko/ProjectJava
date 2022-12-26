import Database.ConnectionDb;
import Scores.Course;
import Scores.InfoOfTask;
import StudentsInfo.Students;
import VK.VKApi;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    protected final static int actMaxScore = 32;
    protected final static int exMaxScore = 411;
    protected final static int pracMaxScore = 2800;
    protected final static int semMaxScore = 32;
    private final static String nameStudent = "Воробьев Александр";

    public static void main(String[] args) throws IOException, ClientException, ParseException, ApiException {
        var students = new Students();
        var course = new Course(actMaxScore, exMaxScore, pracMaxScore, semMaxScore);
        var student = students.getStudent("Элэмбаби  Мохамед Собхи Исмаил");

        System.out.println("Имя текущего студента: " + student.getSurnameName());
        System.out.println("\nСписок всех студентов: " + students.getStudents());
        System.out.println(course.getModules());
        System.out.println("\t");
        System.out.println(student.getResult());
        var module = student.getModule("Ошибки");
        System.out.println(module);
        System.out.println(module.getResult() + "\n");
        System.out.println(student.getFinalScores() + "\n");
        var vk = new VKApi();
        System.out.println(vk.findUserInfo(nameStudent));
        ConnectionDb.main(args);
    }
}

