package com.foa.controller;

import com.foa.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: yerinle
 * Date: 05/06/2011
 * Time: 11:42
 * To change this template use File | Settings | File Templates.
 */

@Controller
public final class HelloController {
    private static Logger log = LoggerFactory.getLogger(HelloController.class);

    private List<Member> members = new ArrayList<Member>();

    public HelloController() {
        members.add(new Member("John", "Lennon"));
        members.add(new Member("Paul", "McCartney"));
        members.add(new Member("George", "Harrison"));
        members.add(new Member("Ringo", "Starr"));
    }

    @RequestMapping
    public void list(Model model) {
        model.addAttribute(members);
    }

    @RequestMapping
    public void member(@RequestParam("id") Integer id, Model model) {
        model.addAttribute(members.get(id));
    }

    @RequestMapping
    public void index(Model model) {
        model.addAttribute("name", "Yinka");
    }
}
