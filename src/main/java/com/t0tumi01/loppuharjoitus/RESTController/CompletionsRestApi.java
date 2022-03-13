package com.t0tumi01.loppuharjoitus.RESTController;

import com.t0tumi01.loppuharjoitus.DataModel.Completion;
import com.t0tumi01.loppuharjoitus.DataService.CompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CompletionsRestApi {

    @Autowired
    CompletionService completionService;

    //Get all completions
    @GetMapping("completions")
    public List<Completion> getCompletions() {
        return completionService.getCompletions();
    }

    //Get one completion (params: id)
    @GetMapping("completion/{id}")
    public Completion getCompletion(@PathVariable int id) {
        Completion c = completionService.getCompletion(id);
        if (c == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else return c;
    }

    //Add one completion
    //Body JSON example:
    //{
    //    "studentID":0,
    //    "courseID":0,
    //    "grade":"NA",
    //    "finishedDate":"13.03.2022"
    //}
    @PostMapping("completion")
    public String addCompletion(@RequestBody Completion completion) {
        return completionService.addCompletion(completion);
    }

    //Edit completion (params: id)
    //Body JSON as in addCompletion
    @PutMapping("completion/{id}")
    public String editCompletion(@PathVariable int id, @RequestBody Completion completion) {
        return completionService.editCompletion(id, completion);
    }

    //Update grade (params: id, grade, finished date)
    //Body JSON as in addCompletion
    @PutMapping("completion")
    public String updateGrade(@RequestParam int id, @RequestParam String grade, @RequestParam String finishedDate) {
        return completionService.updateGrade(id, grade, finishedDate);
    }

    //Delete completion
    @DeleteMapping("completion/{id}")
    public String deleteCompletion(@PathVariable int id) {
        return completionService.deleteCompletion(id);
    }
}
