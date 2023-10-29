package sit.int202.simple.repositories;

import sit.int202.simple.entities.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepository {
    private static List<Subject> subjects;

    public SubjectRepository() {
        if (subjects == null) {
            initialize();
        }
    }

    public List<Subject> findAll() {
        return subjects;
    }

    private static void initialize() {
        subjects = new ArrayList<>(20);

        subjects.add(new Subject("INT100", "Information Technology Fundamentals", 3.0));
        subjects.add(new Subject("INT101", "Programming Fundamentals", 3.0));
        subjects.add(new Subject("INT102", "Web Technology", 1.0));
        subjects.add(new Subject("INT114", "Discrete Mathematics for Information Technology", 3.0));
        subjects.add(new Subject("GEN101", "Physical Education", 1.0));
        subjects.add(new Subject("GEN111", "Man and Ethics of Living", 3.0));
        subjects.add(new Subject("LNG120/LNG220", "General English/Academic English", 3.0));
    }
}

