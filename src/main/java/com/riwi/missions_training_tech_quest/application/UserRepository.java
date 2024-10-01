package com.riwi.missions_training_tech_quest.application;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.missions_training_tech_quest.domain.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
