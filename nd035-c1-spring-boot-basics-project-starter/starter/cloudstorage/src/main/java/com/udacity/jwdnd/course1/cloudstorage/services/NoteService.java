package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Note Management: Add/update/remove text notes
 * Controllers deal with errors
 */
@Service
public class NoteService {

    private final NoteMapper noteMapper;

    public NoteService (NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }


    // add text notes
    public Integer addNote (NoteForm noteForm) {
        Note newNote = new Note (noteForm.getNotetitle(), noteForm.getNotedescription(), noteForm.getUserid());
        noteMapper.addNote(newNote);
        return newNote.getNoteid(); // if added successfully into NoteMapper, it will return an autogenerated noteid.
    }

    // update text notes (its title or description or both)
    public void updateNote (NoteForm noteForm) {
        Note update = noteMapper.getNoteByNoteid(noteForm.getNoteid());
        update.setNotetitle(noteForm.getNotetitle());
        update.setNotedescription(noteForm.getNotedescription());
        noteMapper.updateNote(update);
    }

    // remove text notes -- return true if success
    public boolean deleteByNoteid (Integer noteid) {
        if (noteMapper.getNoteByNoteid(noteid) != null) {
            noteMapper.deleteByNoteid(noteid);
            return true;
        }
        return false;
    }

    // get all notes by userid
    public List<Note> getNotesByUserid (Integer userid) {
        return noteMapper.getNotesByUserid(userid);
    }

    // get a note by its id
    public Note getNoteByNoteid (Integer noteid) {
        return noteMapper.getNoteByNoteid(noteid);
    }

    // get userid from noteid -- a method for adding @preAuthorize at @NoteController
    public Integer getUseridByNoteid (Integer noteid) {
        Note theNote = noteMapper.getNoteByNoteid(noteid);
        if (theNote != null) {
            return theNote.getUserid();
        }
        return -1;
    }
}
