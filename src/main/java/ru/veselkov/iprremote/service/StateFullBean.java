package ru.veselkov.iprremote.service;

import jakarta.ejb.Stateful;
import ru.veselkov.iprremote.model.RemoteModel;

@Stateful
public class StateFullBean {
    public int statefull = 1;

    public void increment(RemoteModel model) {
        System.out.println(statefull);
        statefull = model.getStateFullValue() == 0 ? statefull + 1 : model.getStateFullValue() + statefull;
        model.setStateFullValue(statefull);
        System.out.println(model);
    }
}
