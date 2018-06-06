package com.example.dynamic.base;


import java.util.List;

/**
 * *BaseServiceI:所有自定义Service的顶级接口,封装常用的增删查改操作
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * @param <Model>
 */

public interface BaseService<Model> {


    /**
     * 查询多个对象
     *
     * 通过Page对象，查询数据
     */
    Page<Model> selectListByPage(Page<Model> page) ;

    /**
     * 通过对象参数条件查询，所有的数据
     */
    List<Model> selectList(Model model) ;

    /**
     * 删除通过主键
     * @param id
     * @return
     * @throws Exception
     */
    int deleteByPrimaryKey(Integer id) ;

    int deleteByPrimaryKey(String id) ;

    /**
     * 添加接口，空字段不添加
     * @param record
     * @return
     * @throws Exception
     */
    int insertSelective(Model record);

    /**
     * 查找接口通过主键
     * @param id
     * @return
     * @throws Exception
     */
    Model selectByPrimaryKey(String id) ;
    Model selectByPrimaryKey(Integer id) ;


    /**
     * 修改接口通过
     * @param record
     * @return
     * @throws Exception
     */
    int updateByPrimaryKeySelective(Model record) ;

    /**
     * 修改，根据主键全部替换
     * @param record
     * @return
     * @throws Exception
     */
    int updateByPrimaryKey(Model record) ;

    List<Model> selectAllList();

    /**
     * 软删除
     * @param id
     * @return
     */
    int softDel(String[] id);
}
