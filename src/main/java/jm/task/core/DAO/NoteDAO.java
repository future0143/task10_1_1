package jm.task.core.DAO;

import java.util.Scanner;

public interface NoteDAO {
    void listOfCommands ();
    void noteNew ();
    void noteList ();

    void noteRemove();

    void noteExport();

    void exit(Scanner scanner);
}
