package com.taskManagment.app.repository;


import com.taskManagment.app.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<MyUser, Long> {
}
