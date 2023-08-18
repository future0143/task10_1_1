package jm.task.core.service;

import jm.task.core.DAO.NoteDAO;
import jm.task.core.DAO.NoteDAOlmpl;
import jm.task.core.model.Note;

import java.util.List;
import java.util.Scanner;

public class NoteServiceimpl implements NoteService {
    private NoteDAO noteDao = new NoteDAOlmpl();
    public void startApp() {
        System.out.println("Это Ваша записная книжка. Вот список доступных команд: help,note-new,note-list,note-remove,note-export, exit.");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            switch (line) {
                case "help" -> listOfCommands();   //+
                case "note-new" -> noteNew();      //+
                case "note-list" -> noteList();    //+
                case "note-remove" -> noteRemove();   //+
                case "note-export" -> noteExport();   //+
                case "exit" -> exit(scanner);   //+
                default -> System.out.println("команда не найдена");   //+
            }
        }
    }

    @Override
    public void listOfCommands() {
        noteDao.listOfCommands();
    }

    @Override
    public void noteNew() {
        noteDao.noteNew();
    }

    @Override
    public void noteList() {
        noteDao.noteList();
    }

    @Override
    public void noteRemove() {
        noteDao.noteRemove();
    }

    @Override
    public void noteExport() {
        noteDao.noteExport();
    }

    @Override
    public void exit(Scanner scanner) {
        noteDao.exit(scanner);
    }
}
