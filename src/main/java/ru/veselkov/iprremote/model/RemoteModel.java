package ru.veselkov.iprremote.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "ipr_remote", schema = "public", catalog = "postgres")
public class RemoteModel implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @Basic
    @Column
    private int remoteValue;

    @Basic
    @Column
    private int stateFullValue;

    @Basic
    @Column
    private int statlessValue;

    @Basic
    @Column
    private int singletoneValue;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getRemoteValue() {
        return remoteValue;
    }

    public void setRemoteValue(int remoteValue) {
        this.remoteValue = remoteValue;
    }

    public int getStateFullValue() {
        return stateFullValue;
    }

    public void setStateFullValue(int stateFullValue) {
        this.stateFullValue = stateFullValue;
    }

    public int getStatlessValue() {
        return statlessValue;
    }

    public void setStatlessValue(int statlessValue) {
        this.statlessValue = statlessValue;
    }

    public int getSingletoneValue() {
        return singletoneValue;
    }

    public void setSingletoneValue(int singletoneValue) {
        this.singletoneValue = singletoneValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RemoteModel that = (RemoteModel) o;

        if (remoteValue != that.remoteValue) return false;
        if (stateFullValue != that.stateFullValue) return false;
        if (statlessValue != that.statlessValue) return false;
        if (singletoneValue != that.singletoneValue) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + remoteValue;
        result = 31 * result + stateFullValue;
        result = 31 * result + statlessValue;
        result = 31 * result + singletoneValue;
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RemoteModel.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("remoteValue=" + remoteValue)
                .add("stateFullValue=" + stateFullValue)
                .add("statlessValue=" + statlessValue)
                .add("singletoneValue=" + singletoneValue)
                .toString();
    }
}
