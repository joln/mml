package net.ostree.hibernate;

/**
��Ҫ���裺

1.�������̡�

2.�����ݿⴴ��ʵ���ࣨʹ��hibernate)

3.����hibernate�����ļ�hibernate.cfg.xml������../srcĿ¼�£���Ȼ�Ҳ�����

4.�޸�hibeernate.cfg.xml���ӳ����

5.д������ԣ�
*/

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        Student st1=new Student();
         try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Student");//Student�����������Ǳ���
        List resultList = q.list();
        Iterator itor=resultList.iterator();
        while(itor.hasNext()){
        st1=(Student)itor.next();
        System.out.println(st1.getXingming());
        }
        session.getTransaction().commit();
    } catch (HibernateException he) {
        he.printStackTrace();
    }
    }

}
