package jm.task.core.service;

import jm.task.core.model.Note;

import java.util.List;
import java.util.Scanner;

public interface NoteService {
    void listOfCommands ();
    void noteNew ();
    void noteList ();

    void noteRemove();

    void noteExport();

    void exit(Scanner scanner);
}
