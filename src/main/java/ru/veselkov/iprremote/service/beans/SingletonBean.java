package ru.veselkov.iprremote.service.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Singleton;
import ru.veselkov.iprremote.model.RemoteModel;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class SingletonBean {
    public int singleton = 0;
    private List<Integer> list = new ArrayList<>();

    @PostConstruct
    private void constr() {
        System.out.println("SingletonBean created");
    }

    @PreDestroy
    private void destr() {
        System.out.println("SingletonBean destroyed");
    }

    public void increment(RemoteModel model) {
        System.out.println("SingletonBean begin");
        System.out.println(singleton);
        ++singleton;
        model.setSingletoneValue(singleton);
        list.add(singleton);
        System.out.println("SingletonBean end");
    }

    public int getSingleton() {
        return singleton;
    }

    public void setSingleton(int singleton) {
        this.singleton = this.singleton + singleton;
    }
}
