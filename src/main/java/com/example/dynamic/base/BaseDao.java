package com.example.dynamic.base;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * baseDao,Dao基本类
 * @param <Model>
 */
public interface BaseDao<Model> {

    /**
     * 通过Map条件查询，统计列表数据条数
     */
    Integer count(@Param("obj") Model model) ;
    /**
     * 通过Map条件查询，所有的数据
     */

    List<Model> selectList(@Param("obj") Model model, @Param("page") Integer page, @Param("pageSize") Integer pageSize) ;


    /**
     * 通过对象参数条件查询，所有的数据
     */
    List<Model> selectList(Model model) ;

    /**
     * 删除通过主键
     * @param id
     * @return
     * @
     */
    int deleteByPrimaryKey(Integer id) ;

    int deleteByPrimaryKey(String id);

    /**
     * 添加接口，空字段不添加
     * @param record
     * @return
     * @
     */
    int insertSelective(Model record)  ;

    /**
     * 查找接口通过主键
     * @param id
     * @return
     * @
     */
    Model selectByPrimaryKey(String id) ;

    Model selectByPrimaryKey(Integer id) ;

    /**
     * 修改接口通过
     * @param record
     * @return
     * @
     */
    int updateByPrimaryKeySelective(Model record)  ;

    /**
     * 修改，根据主键全部替换
     * @param record
     * @return
     * @
     */
    int updateByPrimaryKey(Model record) ;

    /**
     * 查询所有记录
     * @return
     */
    List<Model> selectAllList();

    /**
     * 软删除
     * @param id
     * @return
     */
    int softDel(String[] id);
}
