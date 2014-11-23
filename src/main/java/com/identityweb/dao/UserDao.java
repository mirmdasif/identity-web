package com.identityweb.dao;

import com.identityweb.persistence.UserProfile;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by galib on 11/23/14.
 */

public class UserDao {
    @Autowired
    SessionFactory sessionFactory;


    @Transactional
    public void saveUserProfile(UserProfile userProfile){
        Session session = sessionFactory.getCurrentSession();
        session.save(userProfile);
    }

    @Transactional
    public void updateUserProfile(UserProfile userProfile){
        Session session = sessionFactory.getCurrentSession();
        session.update(userProfile);
    }

    @Transactional
    public UserProfile getUserById(int emailVerificationid){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from UserProfile where id = :EID ");
        query.setParameter("EID", emailVerificationid);
        UserProfile userProfile = (UserProfile)query.uniqueResult();
        return userProfile;
    }
}
