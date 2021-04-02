package com.tp.TP.repository;

import org.springframework.data.repository.CrudRepository;

import com.tp.TP.ressource.Note;

//CrudRepository de la Classe Note
public interface NoteRepository extends CrudRepository<Note, Integer>{
	
}
