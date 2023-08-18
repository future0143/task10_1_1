package jm.task.core.DAO;

import jm.task.core.model.Note;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NoteDAOlmpl implements NoteDAO {
    @Override
    public void listOfCommands() {
        for (String commands : Commands.getAllCommands()) {
            System.out.println(commands);
        }
    }

    @Override
    public void noteNew() {
        Scanner scanner = new Scanner(System.in);

        try {
            List<String> labels = null;

            System.out.println("Введите текст заметки: ");
            String text = scanner.nextLine();
            if (text.length() < 3) {
                throw new IllegalArgumentException("Длина заметки должна быть не менее 3 символов.");
            }

            System.out.println("Введите лэйблы: ");
            String label = scanner.nextLine();
            if (!label.isEmpty()) {
                labels = List.of(label.toUpperCase().split(" "));
                String regular = "^[a-zA-Z]+$";
                for (String lab : labels) {     //проверка лэйблов на соответствие регулярному выражению
                    if (!lab.matches(regular)) {
                        throw new IllegalArgumentException("Метка \"" + lab + "\" некорректна. Метки должны состоять только из букв.");
                    }
                }
            }
            Note newNote = new Note(text, labels);
            Note.getListOfNotes().add(newNote);
            System.out.println("Заметка добавлена");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    @Override
    public void noteList() {
        List<String> listLabels;
        List<Note> listNote = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String label;
        System.out.println("Введите метки, чтобы отобразить определенные заметки или оставьте пустым для отображения всех заметок");

        try {
            label = scanner.nextLine();
            if (!label.isEmpty()) {
                listLabels = List.of(label.toUpperCase().split(" "));
                String regular = "^[a-zA-Z]+$";
                for (String lab : listLabels) {     //проверка лэйблов на соответствие регулярному выражению
                    if (!lab.matches(regular)) {
                        throw new IllegalArgumentException("Метка \"" + lab + "\" некорректна. Метки должны состоять только из букв.");
                    } else {
                        for (Note note : Note.getListOfNotes()) {
                            for (String l : listLabels) {
                                if (note.getLabels().contains(l)) {
                                    listNote.add(note);
                                } else {
                                    throw new IllegalArgumentException("Введенная метка отсутствует в заметках");
                                }
                            }
                        }
                    }
                }
            } else {
                for (Note note : Note.getListOfNotes()) {
                    System.out.println(note + "\n" + "===================");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;}
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        for (Note note : listNote) {
            System.out.println(note + "\n" + "===================");
        }
    }


    @Override
    public void noteRemove() {
        Scanner scanner = new Scanner(System.in);
        int id;
        System.out.println("Введите id удаляемой заметки");
        try {
            String idLine = scanner.nextLine();
            id = Integer.parseInt(idLine);
        } catch (NumberFormatException e) {
            System.out.println("Введен некорректный id");
            return;
        }
        Iterator<Note> iterator = Note.getListOfNotes().iterator();
        while (iterator.hasNext()) {
            Note note = iterator.next();
            if (note.getId() == id) {
                iterator.remove();
                System.out.println("Заметка удалена");
            } else {
                System.out.println("Заметка не найдена");
            }
        }
    }

    @Override
    public void noteExport() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String fileName = "notes_" + dateFormat.format(new Date()) + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Note note : Note.getListOfNotes()) {
                writer.write(note + "\n" + "===================" + "\n");
            }
            System.out.println("Заметки успешно сохранены в файл: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при записи заметок: " + e.getMessage());
        }
    }

    @Override
    public void exit(Scanner scanner) {
        scanner.close();
    }
}