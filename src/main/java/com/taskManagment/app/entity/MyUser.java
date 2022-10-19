package com.taskManagment.app.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String username;




    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", updatable = false, insertable = false)
    private List<Task> tasks = new ArrayList<>();

}
