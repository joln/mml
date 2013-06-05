package net.ostree.hibernate;

/**
主要步骤：

1.创建工程。

2.从数据库创建实体类（使用hibernate)

3.创建hibernate配置文件hibernate.cfg.xml，放在../src目录下，不然找不到。

4.修改hibeernate.cfg.xml添加映射类

5.写代码测试：
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
        Query q = session.createQuery("from Student");//Student是类名，不是表名
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
