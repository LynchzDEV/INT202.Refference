package sit.int202.register.models;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class ViewSupport {

  public static Map<String, Boolean> getExistingSubject(int semester,
      HttpSession session) {
    Map<String, Boolean> existingSubject = new HashMap<>();
    if (session != null && session.getAttribute("courseRegistered") != null) {
      for (Subject subject : ((CourseRegistered) session.getAttribute(
          "courseRegistered")).getRegisteredCourse(semester)) {
        existingSubject.put(subject.getSubjectId(), true);
      }
    }
    return existingSubject;
  }
}
