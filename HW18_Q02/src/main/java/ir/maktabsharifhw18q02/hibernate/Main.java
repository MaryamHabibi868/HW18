package ir.maktabsharifhw18q02.hibernate;

import ir.maktabsharifhw18q02.hibernate.config.ApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = ApplicationContext.getInstance();
        context.getEntityManagerFactory();
        context.getEntityManager();

    }
}