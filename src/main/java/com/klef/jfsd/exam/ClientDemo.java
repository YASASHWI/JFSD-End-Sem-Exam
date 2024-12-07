package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientDemo {
    public static void main(String[] args) {
        insertDepartment("Computer Science", "Hyderabad", "Dr. Rajesh");

       // deleteDepartmentById(1);
    }

    public static void insertDepartment(String name, String location, String hodName) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Department department = new Department();
            department.setName(name);
            department.setLocation(location);
            department.setHodName(hodName);

            session.save(department);

            transaction.commit();
            System.out.println("Department inserted successfully.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

//    public static void deleteDepartmentById(int departmentId) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//
//            String hql = "DELETE FROM Department WHERE departmentId = ?1";
//            int result = session.createQuery(hql)
//                                .setParameter(1, departmentId)
//                                .executeUpdate();
//
//            transaction.commit();
//            if (result > 0) {
//                System.out.println("Department with ID " + departmentId + " deleted successfully.");
//            } else {
//                System.out.println("No Department found with ID " + departmentId);
//            }
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        }
//    }
}