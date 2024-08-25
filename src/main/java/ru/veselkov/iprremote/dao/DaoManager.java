package ru.veselkov.iprremote.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.veselkov.iprremote.model.RemoteModel;

@Stateless
public class DaoManager {

    @PersistenceContext(unitName = "ipr")
    private EntityManager entityManager;

    public <T> void persistT(T t) {
        entityManager.persist(t);
    }

    public RemoteModel find(long id) {
        return entityManager.find(RemoteModel.class, id);
    }
}
