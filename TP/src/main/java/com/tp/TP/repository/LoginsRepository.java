package com.tp.TP.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tp.TP.ressource.Logins;

public interface LoginsRepository extends CrudRepository<Logins, Integer>{
	Optional<Logins> findByMailAndPassword(String mail, String password);
}
