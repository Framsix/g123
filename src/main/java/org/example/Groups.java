package org.example;

public class Groups {
    String group;
    String type;
    long number;
    long weight;

    public Groups(String group, String type, long number, long weight) {
        this.group = group;
        this.type = type;
        this.number = number;
        this.weight = weight;
    }

    public String getGroup() {
        return group;
    }

    public String getType() {
        return type;
    }

    public long getNumber() {
        return number;
    }

    public long getWeight() {
        return weight;
    }
}