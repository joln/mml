package net.ostree.hibernate;
import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
 private static SessionFactory sessionFactory;
 
 public static SessionFactory getSessionFactory() {
  return sessionFactory;
 }

 private HibernateUtil(){
  
 }
 
 static{ 
  Configuration cfg=new Configuration();
  cfg.configure();
  sessionFactory=cfg.buildSessionFactory();
 }
 
 public static Session getSession(){
  return sessionFactory.openSession();
 }
 
 public static void add(Object obj){
  Session s=null;
  Transaction tx=null;
  try{
   s=HibernateUtil.getSession();
   tx=s.beginTransaction();
   s.save(obj);   
   tx.commit();  
  }finally{
   if(s!=null)
    s.close();
  }
 }
 
 public static void update(Object obj){
  Session s=null;
  Transaction tx=null;
  try{
   s=HibernateUtil.getSession();
   tx=s.beginTransaction();
   s.update(obj);   
   tx.commit();  
  }finally{
   if(s!=null)
    s.close();
  }
 }
 
 public static void delete(Object obj){
  Session s=null;
  Transaction tx=null;
  try{
   s=HibernateUtil.getSession();
   tx=s.beginTransaction();
   s.delete(obj);   
   tx.commit();  
  }finally{
   if(s!=null)
    s.close();
  }
 }
 
 public static Object get(Class clazz,Serializable id){
  Session s=null;
  try{
   s=HibernateUtil.getSession();   
   Object obj=s.get(clazz, id);   
   return obj;
  }finally{
   if(s!=null)
    s.close();
  }
 }
}

