package com.identityweb.service;

import com.identityweb.dao.UserDao;
import com.identityweb.domain.UserData;
import com.identityweb.persistence.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
   UserDao userDao;

   public UserService(UserDao userDao){
       this.userDao = userDao;
   }

   public int saveSignUpRequest(UserProfile userProfile){
       userProfile.setEmailVerificationStatus("Unverified");
       userProfile.setRequestStatus("Pending");
       userDao.saveUserProfile(userProfile);
       return userProfile.getId();
   }

   public void updateEmailVerificationStatus(String eid){
       int emailVerificationId = Integer.parseInt(eid);
       UserProfile userProfile = userDao.getUserById(emailVerificationId);
       userProfile.setEmailVerificationStatus("Verified");
       userDao.updateUserProfile(userProfile);
   }
}
