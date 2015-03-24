package com.lzjtu.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {


	/**
	 * @return 获取会话工厂
	 */
	private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            //return //new Configuration().configure().buildSessionFactory();
//            SessionFactory sf = 
        	Configuration configuration = new Configuration();
    		configuration.configure("hibernate.cfg.xml");
    		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
    		        .applySettings(configuration.getProperties()).build();
    		return configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


	public static void closeSessionFactory() {
		sessionFactory.close();
	}

	/**
	 * @return 获取会话对象
	 */
	public static Session getSession() {
		return getSessionFactory().openSession();
	}

	/**
	 * @param obj
	 *            添加数据
	 * @return
	 */
	public static boolean add(Object obj) {
		Session session = null;
		Transaction tran = null;
		boolean result = false;
		try {
			session = getSession();
			tran = session.beginTransaction();
			session.save(obj);
			tran.commit();
			result = true;
		} catch (Exception e) {
			if (tran != null) {
				// 事物回滚
				tran.rollback();
			}
		} finally {
			if (session != null) {
				// 关闭session
				session.close();
			}
		}
		return result;
	}

	/**
	 * @return 更新数据 参数为修改的主键id对象
	 */
	public static boolean update(Object object) {
		Session session = null;
		Transaction tran = null;
		boolean result = false;
		try {
			session = getSession();
			tran = session.beginTransaction();
			session.update(object);
			tran.commit();
			result = true;
		} catch (Exception e) {
			if (tran != null) {
				// 事物回滚
				tran.rollback();
			}
		} finally {
			if (session != null) {
				// 关闭session
				session.close();
			}
		}
		return result;
	}

	/**
	 * @param c
	 * @param obj
	 *            查询一条数据根据主键的id号
	 * @return
	 */
	public static Object get(Class c, int obj) {
		Session session = null;
		Object object = null;
		try {
			session = getSession();
			object = session.get(c, obj);
		} catch (Exception e) {
		} finally {
			if (session != null) {
				// 关闭session
				session.close();
			}
		}
		return object;
	}

	/**
	 * @param obj
	 * @return 删除数据
	 */
	public static boolean delete(Object obj) {
		Session session = null;
		Transaction tran = null;
		boolean result = false;
		try {
			session = getSession();
			tran = session.beginTransaction();
			session.delete(obj);
			tran.commit();
			result = true;
		} catch (Exception e) {
			if (tran != null) {
				// 事物回滚
				tran.rollback();
			}
		} finally {
			if (session != null) {
				// 关闭session
				session.close();
			}
		}
		return result;
	}
	

	/**
	 * @param <T>
	 *            查询多条记录
	 * @param sql
	 *            sql语句
	 * @param param
	 *            参数数组
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> query(String sql, String[] param) {
		List<T> list = new ArrayList<T>();
		Session session = null;
		try {
			session = getSession();
			Query query = session.createQuery(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					query.setString(i, param[i]);
				}
			}
			list = query.list();
		} catch (Exception e) {
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	/**
	 * @param sql
	 * @param param
	 *            查询单条记录
	 * @return
	 */
	public static Object queryOne(String sql, String[] param) {
		Object object = null;
		Session session = null;
		try {
			session = getSession();
			Query query = session.createQuery(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					query.setString(i, param[i]);
				}
				object = query.uniqueResult();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询错误！");
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return object;
	}

	/**
	 * @param <T>
	 * @param sql
	 * @param param
	 * @param page
	 * @param size
	 * @return 实现分页查询
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> queryByPage(String sql, String[] param, int page,
			int size) {
		List<T> list = new ArrayList<T>();
		Session session = null;
		try {
			session = getSession();
			Query query = session.createQuery(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					query.setString(i, param[i]);
				}
			}
			// 筛选条数
			query.setFirstResult((page - 1) * size);
			query.setMaxResults(size);
			list = query.list();
		} catch (Exception e) {
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	/**
	 * @param hql
	 * @param pras
	 * @return返回数据个数
	 */
	public static long getCount(String hql, String[] pras) {
		long resu = 0;
		Session s = null;
		try {
			s = getSession();
			Query q = s.createQuery(hql);
			if (pras != null) {
				for (int i = 0; i < pras.length; i++) {
					q.setString(i, pras[i]);
				}
			}
			resu = (long) q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
		}
		return resu;
	}

}