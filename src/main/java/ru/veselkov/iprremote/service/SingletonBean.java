package ru.veselkov.iprremote.service;

import jakarta.ejb.Singleton;
import ru.veselkov.iprremote.model.RemoteModel;

@Singleton
public class SingletonBean {
    public int singleton = 1;

    public void increment(RemoteModel model) {
        System.out.println(singleton);
        singleton = model.getSingletoneValue() == 0 ? singleton + 1 : model.getSingletoneValue() + singleton;
        model.setSingletoneValue(singleton);
        System.out.println(model);
    }
}
