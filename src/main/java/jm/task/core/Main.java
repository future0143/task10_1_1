package jm.task.core;
import jm.task.core.DAO.Commands;
import jm.task.core.service.NoteServiceimpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NoteServiceimpl noteServiceimpl = new NoteServiceimpl();
        noteServiceimpl.startApp();
    }
}
