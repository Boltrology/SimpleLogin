/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rgc.simplelogin.jsf;

import com.rgc.simplelogin.jpa.SimpleUser;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author RGC
 */
@ManagedBean(name = "login", eager = true)
@RequestScoped
public class LoginResponse {

    private static final Logger logger = Logger.getLogger(LoginResponse.class.getName());

    //Crear el jdbc resource: jdbc/simpleLogin
    @PersistenceContext(unitName = "SimpleLoginPU")
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    private String user, password;

    private SimpleUser sp;

    public LoginResponse() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addUser(String user, String password) {
        try {
            ut.begin();
            em.persist(new SimpleUser(user, password));
            ut.commit();
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            logger.warning(ex.getMessage());
        }
    }

    public String validate() {
        TypedQuery<SimpleUser> allElements = em.createQuery("SELECT u FROM SimpleUser AS u", SimpleUser.class);
        TypedQuery<SimpleUser> query = em.createQuery("SELECT u FROM SimpleUser AS u WHERE u.nickname = :name AND u.password = :password", SimpleUser.class);
        query.setParameter("name", user);
        query.setParameter("password", password);

        if (allElements.getResultList().isEmpty()) {
            logger.info("Adding a user!");
            addUser("rodrigo", "rodrigo");
        }

        if (query.getResultList().size() == 1) {
            logger.info("Login 0k");
            sp = query.getSingleResult();
            return "success";
        } else {
            logger.warning("Login fail");
            return "failure";
        }
    }

    public SimpleUser getLoginUser() {
        return sp;
    }

}
