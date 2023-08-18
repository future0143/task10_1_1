package jm.task.core.model;

import java.util.UUID;

class IdGenerator {
    private static int count = 0;
    public static int generateId() {
        return ++count;
    }
}
