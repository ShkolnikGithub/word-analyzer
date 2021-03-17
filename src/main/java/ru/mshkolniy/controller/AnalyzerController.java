package ru.mshkolniy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mshkolniy.model.Letter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AnalyzerController {

    @GetMapping("/wordanalyzer/analyze")
    public String getLetter(@RequestParam String word, Model model) throws IOException {
        Map<Character, Integer> letters = new HashMap<>();
        char resultLetter = '\u0000';
        int maxCount = 0;

        for (int i = 0; i < word.length(); i++) {
            if (letters.containsKey(word.charAt(i))) {
                letters.put(word.charAt(i), letters.get(word.charAt(i)) + 1);
            } else {
                letters.put(word.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                resultLetter = entry.getKey();
            }
        }

        for (int i = 0; i < word.length(); i++) {
            if (letters.get(word.charAt(i)) == maxCount) {
                resultLetter = word.charAt(i);
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        mapper.writerWithDefaultPrettyPrinter().writeValue(stringWriter, new Letter(resultLetter, maxCount));

        model.addAttribute("letter", stringWriter);

        return "letter";
    }
}
