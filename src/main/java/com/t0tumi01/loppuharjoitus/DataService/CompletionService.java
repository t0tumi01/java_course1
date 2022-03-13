package com.t0tumi01.loppuharjoitus.DataService;

import com.t0tumi01.loppuharjoitus.DataModel.Completion;
import com.t0tumi01.loppuharjoitus.FileService.CompletionFileService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompletionService {
    private List<Completion> completions = new ArrayList<>();

    //Constructor
    public CompletionService() {
        //Get completions from file
        CompletionFileService fs = new CompletionFileService();
        completions = fs.readCompletionsFromFile();
    }

    //Get all completions
    public List<Completion> getCompletions() {
        return new ArrayList<>(completions);
    }

    //Get one completion
    //id = object array id
    public Completion getCompletion(int id) {
        Completion c = new Completion();
        if (id < completions.size()) {
            c = completions.get(id);
        }
        else c = null;

        return c;
    }

    //Add completion
    //completion = completion object
    public String addCompletion(Completion completion) {
        //Get student and courses from file
        StudentService ss = new StudentService();
        CourseService cs = new CourseService();
        if (ss.getStudents().size() > completion.getStudentID() && cs.getCourses().size() > completion.getCourseID()) {
            completions.add(completion);
            //Write completions to file
            CompletionFileService fs = new CompletionFileService();
            fs.writeCompletionsToFile(completions);
            return "Completion added OK";
        }
        else return "Student or course ID does not exist!";
    }

    //Edit completion
    //id = object array id
    //completion = completion object
    public String editCompletion(int id, Completion completion) {
        if (id < completions.size()) {
            completions.set(id, completion);
            //Write completions to file
            CompletionFileService fs = new CompletionFileService();
            fs.writeCompletionsToFile(completions);
            return "Completion edited OK";
        }
        else return "Completion ID does not exist";
    }

    //Update grade
    //id = object array id
    //grade = new grade
    //date = new finished date
    public String updateGrade(int id, String grade, String date) {
        if (id < completions.size()) {
            Completion c = completions.get(id);
            c.setGrade(grade);
            c.setFinishedDate(date);
            completions.set(id, c);
            //Write completions to file
            CompletionFileService fs = new CompletionFileService();
            fs.writeCompletionsToFile(completions);
            return "Completion updated OK";
        }
        else return "Completion ID does not exist";
    }

    //Delete completion
    //id = object array id
    public String deleteCompletion(int id) {
        if (id < completions.size()) {
            completions.remove(id);
            //Write completions to file
            CompletionFileService fs = new CompletionFileService();
            fs.writeCompletionsToFile(completions);
            return "Completion deleted OK";
        } else return "Completion ID does not exist";
    }
}
