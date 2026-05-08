package ltn.vieccanlam;

import java.util.HashMap;

public class TASKS {
    String name;
    String date;
    String message;
    int priority;

    public TASKS(String name, String date, String message, int priority) {
        this.name = name;
        this.date = date;
        this.message = message;
        this.priority = priority;
    }

    public TASKS() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    //
    public HashMap<String, Object> toFirebaseObject() {

        HashMap<String, Object> taskObject = new HashMap<>();

        taskObject.put("name", name);
        taskObject.put("date", date);
        taskObject.put("message", message);
        taskObject.put("priority", priority);

        return taskObject;
    }
}
