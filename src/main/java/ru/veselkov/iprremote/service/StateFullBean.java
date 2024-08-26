package ru.veselkov.iprremote.service;

import jakarta.ejb.Stateful;
import ru.veselkov.iprremote.model.RemoteModel;

import java.util.ArrayList;
import java.util.List;

@Stateful
public class StateFullBean {
    private int statefull = 1;
    private List<Integer> list = new ArrayList<>();


    public void increment(RemoteModel model) {
        System.out.println(statefull);
        statefull = model.getStateFullValue() == 0 ? statefull + 1 : model.getStateFullValue() + statefull;
        model.setStateFullValue(statefull);
        list.add(statefull);
    }

    public void increment() {
        statefull++;
        list.add(statefull);
    }

    public void env() {
        System.out.println("StateFullBean begin");
        System.out.println(statefull);
        System.out.println(list);
    }

    public void env2() {
        System.out.println("StateFullBean end");
        System.out.println(statefull);
        System.out.println(list);
    }
}
