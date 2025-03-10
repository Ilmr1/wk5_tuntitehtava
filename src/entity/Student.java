package entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimeSpent> timeSpentList = new ArrayList<>();

    public Student() {}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TimeSpent> getTimeSpentList() {
        return timeSpentList;
    }

    public void setTimeSpentList(List<TimeSpent> timeSpentList) {
        this.timeSpentList = timeSpentList;
    }

    public void addTimeSpent(TimeSpent timeSpent) {
        timeSpentList.add(timeSpent);
        timeSpent.setStudent(this);
    }

    public void removeTimeSpent(TimeSpent timeSpent) {
        timeSpentList.remove(timeSpent);
        timeSpent.setStudent(null);
    }
}