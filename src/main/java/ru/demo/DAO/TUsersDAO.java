/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.demo.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import ru.demo.bean.TUsers;

/**
 *
 * @author vasil
 */
public class TUsersDAO {

    public List<TUsers> getUsers(EntityManager em) {
        List<TUsers> res = null;

        TypedQuery<TUsers> namedQuery = em.createNamedQuery("TUsers.findAll", TUsers.class);
        res = namedQuery.getResultList();

        return res;
    }

}
