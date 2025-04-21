package ir.maktabsharifhw18q02.hibernate.repository;

import ir.maktabsharifhw18q02.hibernate.entity.Student;

import java.util.List;


public interface PersonRepository <T> {

    T save(T t);

    T update(T t);

    void delete(T t);

    List<T> loadAll();

    boolean contains(T t);

    T findById(Integer id);
}
