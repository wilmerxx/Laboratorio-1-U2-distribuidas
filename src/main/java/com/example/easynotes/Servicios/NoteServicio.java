package com.example.easynotes.Servicios;

import com.example.easynotes.Excepcion.ResourceNotFoundException;
import com.example.easynotes.Modelo.Note;
import com.example.easynotes.Repositorios.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServicio {

    @Autowired
    NoteRepository noteRepository;

    //crear nota
    public Note createNote (Note note){
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    public Note getNoteById(Long noteId){
        return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    public Note updateNote (Long noteId, Note noteDetails){
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());
        return noteRepository.save(note);
    }

    public void deleteNote (Long noteId){
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        noteRepository.delete(note);
    }

    public Note findByTitle(String title){
        return noteRepository.findByTitle(title);
    }

    public List<Note> findByTitleAndContent(String title,String content){
        return noteRepository.findByTitleAndContent(title,content);
    }

    public Note findByTitleJPQL(String title){
        return noteRepository.findByTitleJPQL(title);
    }

    public List<Note> findByTitleAndContentJPQL(String title, String content){
        return noteRepository.findByTitleAndContentJPQL(title,content);
    }

    public Note findByTitleSQLNativo(String title){
        return noteRepository.findByTitleSQLNativo(title);
    }

    public List<Note> findByTitleAndContentSQLNativo( String title, String content){
        return noteRepository.findByTitleAndContentSQLNativo(title,content);
    }

    public void deleteAll(){
        noteRepository.deleteAll();
    }

}
