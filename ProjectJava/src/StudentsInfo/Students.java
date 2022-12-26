package StudentsInfo;

import Scores.CSVParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Students {
    private final ArrayList<Student> studentsWithGroups;
    private final ArrayList<String> groups;
    private final ArrayList<String> students;

    public Students() throws IOException {
        studentsWithGroups = new CSVParser().getStudentsGroup();
        groups = new CSVParser().getGroups();
        students = new CSVParser().getStudents();
    }

    public ArrayList<Student> getStudentsWithGroups(){return studentsWithGroups;}
    public ArrayList<String> getGroups(){return groups;}
    public ArrayList<String> getStudents(){return students;}

    public Student getStudent(String surnameName) {
        for(var i: studentsWithGroups){
            if (Objects.equals(i.getSurnameName(), surnameName)){
                return i;
            }
        }
        return null;
    }
}
