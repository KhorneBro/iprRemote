package ru.veselkov.iprremote.service;

import jakarta.ejb.Singleton;
import ru.veselkov.iprremote.model.RemoteModel;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class SingletonBean {
    public int singleton = 1;
    private List<Integer> list = new ArrayList<>();

    public void increment(RemoteModel model) {
        System.out.println(singleton);
        singleton = model.getSingletoneValue() == 0 ? singleton + 1 : model.getSingletoneValue() + singleton;
        model.setSingletoneValue(singleton);
        list.add(singleton);
    }

    public void increment() {
        singleton++;
        list.add(singleton);
    }

    public void env() {
        System.out.println("SingletonBean begin");
        System.out.println(singleton);
        System.out.println(list);
    }

    public void env2() {
        System.out.println("SingletonBean end");
        System.out.println(singleton);
        System.out.println(list);
    }
}
