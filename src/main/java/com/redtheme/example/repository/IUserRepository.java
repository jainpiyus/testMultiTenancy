package com.redtheme.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redtheme.example.entity.User;


@Repository
public interface IUserRepository  extends JpaRepository<User,Long>{

}
