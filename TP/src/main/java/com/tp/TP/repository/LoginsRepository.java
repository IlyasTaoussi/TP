package com.tp.TP.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tp.TP.ressource.Logins;

public interface LoginsRepository extends CrudRepository<Logins, Integer>{
	@Query("select l from Logins l where l.mail = :mail and l.password = :password ")
	Optional<Logins> findByMailAndPassword(@Param("mail") String mail,@Param("password") String password);
	Optional<Logins> findByMail(String mail);
}
