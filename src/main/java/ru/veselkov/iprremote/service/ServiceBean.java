package ru.veselkov.iprremote.service;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import ru.veselkov.iprremote.dao.DaoManager;
import ru.veselkov.iprremote.model.RemoteModel;

@Stateless
public class ServiceBean implements RemoteServiceIpr {

    @EJB
    private DaoManager daoManager;

    @EJB
    private StatelessBean statelessBean;
    @EJB
    private StateFullBean stateFullBean;
    @EJB
    private SingletonBean singletonBean;
    @EJB
    private EjbTesterOne ejbTesterOne;
    @EJB
    private EjbTesterTwo ejbTesterTwo;

    @Override
    public void callRemote() {
        System.out.println("remote bean");

        RemoteModel remoteModel = new RemoteModel();
        remoteModel.setRemoteValue(1);
        statelessBean.increment(remoteModel);
        stateFullBean.increment(remoteModel);
        singletonBean.increment(remoteModel);

        daoManager.persistT(remoteModel);
        System.out.println(remoteModel);
    }

    @Override
    public void callRemote(RemoteModel model) {

        ejbTesterOne.test();
        ejbTesterTwo.test();
    }

    @Override
    public void callRemote(long id) {
        RemoteModel remoteModel = daoManager.find(id);
        if (remoteModel == null) {
            remoteModel = new RemoteModel();
        }
        remoteModel.setRemoteValue(1);

        statelessBean.increment(remoteModel);
        statelessBean.env();

        stateFullBean.increment(remoteModel);
        stateFullBean.env();

        singletonBean.increment(remoteModel);
        singletonBean.env();

        daoManager.persistT(remoteModel);
    }
}
