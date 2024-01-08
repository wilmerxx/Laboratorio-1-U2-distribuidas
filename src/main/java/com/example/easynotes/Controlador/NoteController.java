package com.example.easynotes.Controlador;

import com.example.easynotes.Excepcion.ResourceNotFoundException;
import com.example.easynotes.Modelo.Note;
import com.example.easynotes.Repositorios.NoteRepository;
import com.example.easynotes.Servicios.NoteServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {
    @Autowired
    NoteServicio noteServicio;
    // Get All Notes
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteServicio.getAllNotes();
    }
    // Create a new Note
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteServicio.createNote(note);
    }
    // Get a Single Note
    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
        return noteServicio.getNoteById(noteId);
    }
    // Update a Note
    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody Note noteDetails) {
        return noteServicio.updateNote (noteId, noteDetails);
    }
    // Delete a Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        noteServicio.deleteNote (noteId);
        return ResponseEntity.ok().build();
    }

    //consultas
    @GetMapping("/notes/title/{title}")
    public Note findByTitle(@PathVariable(value = "title") String title) {
        return noteServicio.findByTitle(title);
    }

    @GetMapping("/notes/titleAndContent/{title}/{content}")
    public List<Note> findByTitleAndContent(@PathVariable(value = "title") String title,@PathVariable(value = "content") String content) {
        return noteServicio.findByTitleAndContent(title,content);
    }

    @GetMapping("/notes/titleJPQL/{title}")
    public Note findByTitleJPQL(@PathVariable(value = "title") String title) {
        return noteServicio.findByTitleJPQL(title);
    }

    @GetMapping("/notes/titleAndContentJPQL/{title}/{content}")
    public List<Note> findByTitleAndContentJPQL(@PathVariable(value = "title") String title,@PathVariable(value = "content") String content) {
        return noteServicio.findByTitleAndContentJPQL(title,content);
    }

    @GetMapping("/notes/titleSQLNativo/{title}")
    public Note findByTitleSQLNativo(@PathVariable(value = "title") String title) {
        return noteServicio.findByTitleSQLNativo(title);
    }

    @GetMapping("/notes/titleAndContentSQLNativo/{title}/{content}")
    public List<Note> findByTitleAndContentSQLNativo(@PathVariable(value = "title") String title,@PathVariable(value = "content") String content) {
        return noteServicio.findByTitleAndContentSQLNativo(title,content);
    }
}
