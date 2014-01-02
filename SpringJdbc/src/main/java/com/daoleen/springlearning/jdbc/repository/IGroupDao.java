package com.daoleen.springlearning.jdbc.repository;

import com.daoleen.springlearning.jdbc.domain.Group;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/30/13
 * Time: 3:04 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IGroupDao {
    public List<Group> findAll();
    public String findGroupNameById(Long id);
    public Long findIdByGroupName(String name);
//    public void insert(Group group);
//    public void update(Group group);
//    public void delete(Long groupId);
}
