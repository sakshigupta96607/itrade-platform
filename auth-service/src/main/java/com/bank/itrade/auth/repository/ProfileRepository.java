package com.bank.itrade.auth.repository;



import com.bank.itrade.auth.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;





public interface ProfileRepository extends JpaRepository<Profile, String> {

    List<Profile> findByOperatorId(String operatorId);
}



