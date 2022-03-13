package com.t0tumi01.loppuharjoitus.FileService;

import com.t0tumi01.loppuharjoitus.DataModel.Completion;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class CompletionFileService {
    public void writeCompletionsToFile(List<Completion> completions) {
        try {
            FileWriter fw = new FileWriter(new File("completions.txt"), false);
            for(Completion c : completions) {
                fw.write(c.getStudentID() + "," + c.getCourseID() + "," + c.getGrade() + "," + c.getFinishedDate() + System.lineSeparator());
            }
            fw.close();
        }

        catch (Exception e) {
        }
    }

    public List<Completion> readCompletionsFromFile() {
        List<Completion> completions = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("completions.txt"));
            while (sc.hasNextLine()) {
                String s[] = sc.nextLine().split(",");
                if (s.length == 4) {
                    completions.add(new Completion(Integer.parseInt(s[0]), Integer.parseInt(s[1]), s[2], s[3]));
                }
            }
        }

        catch (Exception e) {
        }

        return completions;
    }
}
