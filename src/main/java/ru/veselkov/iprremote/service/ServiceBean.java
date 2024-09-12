package ru.veselkov.iprremote.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.*;
import jakarta.transaction.TransactionRolledbackException;
import ru.veselkov.iprremote.dao.DaoManager;
import ru.veselkov.iprremote.model.RemoteModel;
import ru.veselkov.iprremote.service.beans.SingletonBean;
import ru.veselkov.iprremote.service.beans.StateFullBean;
import ru.veselkov.iprremote.service.beans.StatelessBean;

import java.rmi.RemoteException;

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

    //    1 EJBException: Общее исключение, возникающее при ошибках бизнес-логики
//    или проблемах с доступом к данным в EJB.
//    Это необработанное исключение и может быть распространено по цепочке.
//    2 RemoteException: Возникает при проблемах,
//    связанных с удалёнными вызовами, например,
//    если сервер БД недоступен или происходит сбой сети.
//    Это также необработанное исключение.
//    3 TransactionRolledbackException: Выбрасывается,
//    когда транзакция была откатена.
//    Это может произойти, если в процессе выполнения метода возникает ошибка,
//    и необходимо вернуть систему к предыдущему состоянию.
//    4 CreateException и RemoveException: Появляются при попытке создать
//    или удалить бины EJB.
//    Обычно это связано с некорректными параметрами или состоянием.
//    5 BeanNotFoundException: Выбрасывается,
//    когда запрашиваемый бен не найден.
//    Это может случиться, если пытаетесь получить доступ
//    к удалённому объекту, который не существует или был удалён.
    @Override
    public void callRemote(int id) {
        switch (id) {
            case 1:
                throw new EJBException();
            case 2:
                try {
                    throw new RemoteException();
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            case 3:
                try {
                    throw new TransactionRolledbackException();
                } catch (TransactionRolledbackException e) {
                    throw new RuntimeException(e);
                }
            case 4:
                try {
                    throw new CreateException();
                } catch (CreateException e) {
                    throw new RuntimeException(e);
                }
            case 5:
                try {
                    throw new RemoveException();
                } catch (RemoveException e) {
                    throw new RuntimeException(e);
                }
        }
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
