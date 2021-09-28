package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SkillsController {

    @GetMapping
    @ResponseBody
    public String skillsTracker() {

        return "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>JavaScript</li>" +
                "<li>Python</li>";
    }

    // handles get & post request of the form /form
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="skillsPost")
    @ResponseBody
    public String skillsFormWithRequestParam(@RequestParam String name, @RequestParam String language1, @RequestParam String language2, @RequestParam String language3) {

        return "<h1>" + name + "</h1>" +
                "<ol>" +
                    "<li>" + language1 + "</li>" +
                    "<li>" + language2 + "</li>" +
                    "<li>" + language3 + "</li>" +
                "</ol>";
    }

    // form can also use post method ... which in turn is using the above
    // /form controller method above
    @GetMapping("form")
    @ResponseBody
    public String skillsForm() {
        return "<html>" +
                "<body>" +
                "<form action='skillsPost' method='post'>" + // submit a request to /skillsPost
                "<label>Name:</label> <br>" +
                "<input type='text' name='name'> <br>" +
                "<label>My Favorite Language</label> <br>" +
                "<select name='language1'>" +
                    "<option value='Java'>Java</option>" +
                    "<option value='JavaScript'>JavaScript</option>" +
                    "<option value='Python'>Python</option>" +
                "</select> <br>" +
                "<label>My Second Favorite Language</label> <br>" +
                "<select name='language2'>" +
                    "<option value='Java'>Java</option>" +
                    "<option value='JavaScript'>JavaScript</option>" +
                    "<option value='Python'>Python</option>" +
                "</select> <br>" +
                "<label>My Third Favorite Language</label> <br>" +
                "<select name='language3'>" +
                    "<option value='Java'>Java</option>" +
                    "<option value='JavaScript'>JavaScript</option>" +
                    "<option value='Python'>Python</option>" +
                "</select> <br>" +
                "<input type='submit' value='Submit'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
