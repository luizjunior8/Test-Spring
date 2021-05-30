package com.ufpb.lcc.jrwalker.repository;

import com.ufpb.lcc.jrwalker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
