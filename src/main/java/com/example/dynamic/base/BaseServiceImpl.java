package com.example.dynamic.base;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * @param <Model>
 * @param <Mapper>
 */

public class BaseServiceImpl<Model,Mapper extends BaseDao<Model>> implements BaseService<Model> {
    @Autowired
    protected Mapper mapper;

    public Mapper getMapper() {
        return mapper;
    }

    @Override
    public List<Model> selectList(Model model)  {
        //可以做一系列逻辑操作
        return mapper.selectList(model);
    }

    @Override
    public int deleteByPrimaryKey(Integer id)  {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insertSelective(Model record)   {
        return mapper.insertSelective(record);
    }

    @Override
    public Model selectByPrimaryKey(String id)  {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Model record)   {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Model record)  {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public Page<Model> selectListByPage(Page<Model> page) {
        page.setData(mapper.selectList(page.getFilter(),(page.getPage()-1) * page.getLimit(),page.getLimit()));
        page.setTotal(mapper.count(page.getFilter()));
        return page;
    }

    @Override
    public List<Model> selectAllList() {
        return mapper.selectAllList();
    }

    @Override
    public int softDel(String[] id) {
        return mapper.softDel(id);
    }

    @Override
    public Model selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }
}

