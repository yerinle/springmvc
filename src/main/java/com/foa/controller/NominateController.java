package com.foa.controller;

import com.foa.domain.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IntelliJ IDEA.
 * User: yerinle
 * Date: 05/06/2011
 * Time: 14:11
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class NominateController {
    private static Logger log = LoggerFactory.getLogger(NominateController.class);

    @Autowired
    private SessionFactory sessionFactory;

    private String thanksViewName;

    public void setThanksViewName(String thanksViewName) {
        this.thanksViewName = thanksViewName;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Member form() {
        return new Member();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processFormData(Member member) {
        log.info("Processing nominee: " + member);
        if (sessionFactory == null)  {
            log.debug("Session factory hasn't been wired");
        } else {
            log.debug("Session factory is wired");
        }
        Session session = sessionFactory.openSession();
        session.save(member);
        session.close();
        return thanksViewName;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
