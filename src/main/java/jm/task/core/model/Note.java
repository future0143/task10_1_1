package jm.task.core.model;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Note extends IdGenerator{
    @Getter
    private static List<Note> listOfNotes = new ArrayList<>();
    private int id;
    String text;
    List<String> labels;

    public Note(String text, List<String> labels) {
        this.id = generateId();
        this.text = text;
        this.labels = labels;
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append("#");
        sb.append(text+"\n");

        if (labels != null && !labels.isEmpty()) {
            for (String label : labels) {
                sb.append(label).append("; ");
            }
            sb.setLength(sb.length() - 2); // Убираем последнюю ;
        }
        return sb.toString();
    }

    public List<String> getLabels() {
        return labels;
    }
}
