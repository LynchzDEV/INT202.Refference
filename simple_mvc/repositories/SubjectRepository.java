package sit202.simple.simple_mvc_lab.repositories;

import sit202.simple.simple_mvc_lab.entities.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepository {
    private static List<Subject> subjects;

    public List<Subject> findAll() {
        return subjects;
    }

    public SubjectRepository() {
        initialize();
    }

    private void initialize() {
        subjects = new ArrayList<>(20);
        subjects.add(new Subject("101", "Computer programing", 3.5));
        subjects.add(new Subject("102", "Web Programing", 1));
        subjects.add(new Subject("103", "Statistics for IT", 2));
        subjects.add(new Subject("202", "Basic SQL", 3));
        subjects.add(new Subject("203", "English Reading", 3));
        subjects.add(new Subject("205", "Docker", 1.5));
        subjects.add(new Subject("213", "Networking", 3.5));
    }
}
