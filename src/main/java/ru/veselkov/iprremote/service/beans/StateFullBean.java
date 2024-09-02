package ru.veselkov.iprremote.service.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateful;
import ru.veselkov.iprremote.model.RemoteModel;

import java.util.ArrayList;
import java.util.List;

@Stateful
public class StateFullBean {
    private int statefull = 0;
    private List<Integer> list = new ArrayList<>();

    @PostConstruct
    private void constr() {
        System.out.println("StateFullBean created");
    }

    @PreDestroy
    private void destr() {
        System.out.println("StateFullBean destroyed");
    }

    public void increment(RemoteModel model) {
        System.out.println("StateFullBean begin");
        System.out.println(statefull);
        ++statefull;
        model.setStateFullValue(statefull);
        list.add(statefull);
        System.out.println("StateFullBean end");
    }

    public int getStatefull() {
        return statefull;
    }

    public void setStatefull(int statefull) {
        this.statefull = this.statefull + statefull;
    }
}
