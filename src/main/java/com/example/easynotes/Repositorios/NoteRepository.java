package com.example.easynotes.Repositorios;

import com.example.easynotes.Modelo.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    //consuta por ORM
    public Note findByTitle(String title);

    //consulta por ORM con dos parametros
    public List<Note> findByTitleAndContent(String title,String content);

    //consulta por jpql
    @Query("SELECT n FROM Note n WHERE n.title = ?1")
    public Note findByTitleJPQL(String title);

    //consulta por jpql con dos parametros
    @Query("SELECT n FROM Note n WHERE n.title =:title AND n.content =:content")
    public List<Note> findByTitleAndContentJPQL(@Param("title") String title,@Param("content") String content);

    //consulta con sql nativo
    @Query(value = "SELECT * FROM notes n WHERE n.title = ?1", nativeQuery = true)
    public Note findByTitleSQLNativo(String title);

    //consulta con sql nativo con dos parametros
    @Query(value = "SELECT * FROM notes n WHERE n.title =:title AND n.content =:content", nativeQuery = true)
    public List<Note> findByTitleAndContentSQLNativo(@Param("title") String title,@Param("content") String content);

}
