package cn.mislily.dao.impl;

import cn.mislily.dao.BaseDao;
import cn.mislily.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {

    private Class type = null;

    private QueryRunner queryRunner = new QueryRunner();

    public BaseDaoImpl(){

        ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();

        Type[] types = parameterizedType.getActualTypeArguments();

        type = (Class) types[0];
    }

    @Override
    public T queryForOne(String sql, Object... params) {

        Connection connection = null;

        try {

            connection = JdbcUtils.getConnection();

            T bean = queryRunner.query(connection, sql, new BeanHandler<T>(type), params);

            return bean;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }

        return null;
    }

    @Override
    public List<T> queryForList(String sql, Object... params) {

        Connection connection = null;

        try {

            connection = JdbcUtils.getConnection();

            List<T> beans = queryRunner.query(connection, sql, new BeanListHandler<T>(type),params);

            return beans;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }

        return null;
    }

    @Override
    public int update(String sql, Object... params) {

        Connection connection = null;

        try {

            connection = JdbcUtils.getConnection();

            int ChangedRow = queryRunner.update(connection, sql, params);

            return ChangedRow;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }

        return -1;
    }

    @Override
    public <E> E queryForValue(String sql, Object... params) {

        Connection connection = null;

        try {
            connection = JdbcUtils.getConnection();

            E result = queryRunner.query(connection, sql, new ScalarHandler<E>(),params);

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }

        return null;
    }
}
