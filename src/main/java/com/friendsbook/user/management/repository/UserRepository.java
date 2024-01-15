package com.friendsbook.user.management.repository;

import com.friendsbook.user.management.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Integer> {
}
