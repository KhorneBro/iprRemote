package ru.veselkov.iprremote.service;

import jakarta.ejb.Stateless;
import ru.veselkov.iprremote.model.RemoteModel;

@Stateless
public class StatelessBean {

    public int statelessInt = 1;

    public void increment(RemoteModel model) {
        System.out.println(statelessInt);
        statelessInt = model.getStatlessValue() == 0 ? statelessInt + 1 : model.getStatlessValue() + statelessInt;
        model.setStatlessValue(statelessInt);
        System.out.println(model);
    }
}
