package cn.mislily.dao;

import java.util.List;

public interface BaseDao<T> {

    public T queryForOne(String sql, Object... params);

    public List<T> queryForList(String sql, Object... params);

    public int update(String sql, Object... params);

    public <E> E queryForValue(String sql, Object... params);

}
