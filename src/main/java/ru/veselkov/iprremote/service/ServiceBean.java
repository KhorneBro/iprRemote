package ru.veselkov.iprremote.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import ru.veselkov.iprremote.dao.DaoManager;
import ru.veselkov.iprremote.model.RemoteModel;
import ru.veselkov.iprremote.service.beans.SingletonBean;
import ru.veselkov.iprremote.service.beans.StateFullBean;
import ru.veselkov.iprremote.service.beans.StatelessBean;

@Stateless
public class ServiceBean implements RemoteServiceIpr {

    private Integer integer = 0;

    @EJB
    private DaoManager daoManager;

    @EJB
    private StatelessBean statelessBean;
    @EJB
    private StateFullBean stateFullBean;
    @EJB
    private SingletonBean singletonBean;

    @PostConstruct
    private void constdd() {
        System.out.println(" Bean ServiceBean created  " + integer);
    }

    @PreDestroy
    private void destr() {
        System.out.println(" Bean ServiceBean destroy  " + integer);
    }

    @Override
    public void callRemote() {
        System.out.println("remote bean");
        System.out.println(integer);
        integer++;
        RemoteModel remoteModel = new RemoteModel();
        remoteModel.setRemoteValue(1);
        statelessBean.increment(remoteModel);
        stateFullBean.increment(remoteModel);
        singletonBean.increment(remoteModel);

        statelessBean.increment(remoteModel);
        stateFullBean.increment(remoteModel);
        singletonBean.increment(remoteModel);

        daoManager.persistT(remoteModel);
        System.out.println(remoteModel);
        System.out.println(integer);
    }

    @Override
    public void callRemote(RemoteModel model) {

    }

    @Override
    public void callRemote(long id) {
        RemoteModel remoteModel = daoManager.find(id);
        if (remoteModel == null) {
            remoteModel = new RemoteModel();
        }
        remoteModel.setRemoteValue(1);

        statelessBean.increment(remoteModel);

        stateFullBean.increment(remoteModel);

        singletonBean.increment(remoteModel);

        System.out.println(remoteModel);

        daoManager.persistT(remoteModel);
    }
}
