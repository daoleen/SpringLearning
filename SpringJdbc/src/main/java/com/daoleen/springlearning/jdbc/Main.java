package com.daoleen.springlearning.jdbc;

import com.daoleen.springlearning.jdbc.domain.Group;
import com.daoleen.springlearning.jdbc.repository.IGroupDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/30/13
 * Time: 3:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("app-context-xml.xml");
        IGroupDao groupDao = context.getBean("groupDao", IGroupDao.class);

        String groupName = groupDao.findGroupNameById(3L);
        System.out.println("Group name with id=3: " + groupName);

        Long id = groupDao.findIdByGroupName("FITy");
        System.out.println("Id for group 'FITY' is: " + id);

        System.out.println("\nList of groups:");
        for(Group group : groupDao.findAll()) {
            System.out.println(group);
        }


        // TODO: Остановился на стр. 316
    }
}
