package com.example.easynotes.Repositorios;

import com.example.easynotes.Modelo.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {


}
