package com.taotao.manager.service.impl;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * PACKAGE_NAME com.taotao.manager.service.impl
 * Created by ltfedware on 2017/11/9.
 */
public class BaseServiceImpl<T> {
    @Autowired
    private Mapper<T>  mapper;

    private Class clazz;
    public BaseServiceImpl() {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) genericSuperclass;
        clazz = (Class) type.getActualTypeArguments()[0];
    }


    public int save(T t) {
        return mapper.insert(t);
    }

    /* (non-Javadoc)
     * @see com.taotao.manager.service.BaseService#saveSelective(java.lang.Object)
     */
    public int saveSelective(T t) {
        // TODO Auto-generated method stub
        return mapper.insertSelective(t);
    }

    /* (non-Javadoc)
     * @see com.taotao.manager.service.BaseService#delete(java.lang.Object)
     */
    public int delete(T t) {
        // TODO Auto-generated method stub
        return mapper.delete(t);
    }

    /* (non-Javadoc)
     * @see com.taotao.manager.service.BaseService#deleteById(java.lang.Object)
     */
    public int deleteById(Object t) {
        // TODO Auto-generated method stub
        return mapper.deleteByPrimaryKey(t);
    }

    /* (non-Javadoc)
	 * @see com.taotao.manager.service.BaseService#getOneById(java.lang.Object)
	 */
    public T getOneById(Object id) {
        // TODO Auto-generated method stub
        return mapper.selectByPrimaryKey(id);
    }

    /* (non-Javadoc)
     * @see com.taotao.manager.service.BaseService#getOne(java.lang.Object)
     */
    public T getOne(T t) {
        // TODO Auto-generated method stub
        return mapper.selectOne(t);
    }

    /* (non-Javadoc)
     * @see com.taotao.manager.service.BaseService#update(java.lang.Object)
     */
    public int update(T t) {
        // TODO Auto-generated method stub
        return mapper.updateByPrimaryKey(t);
    }

    /* (non-Javadoc)
     * @see com.taotao.manager.service.BaseService#updateSelective(java.lang.Object)
     */
    public int updateSelective(T t) {
        // TODO Auto-generated method stub
        return mapper.updateByPrimaryKeySelective(t);
    }

    /* (non-Javadoc)
     * @see com.taotao.manager.service.BaseService#getList()
     */
    public List<T> getList() {
        return mapper.select(null);
    }

    public PageInfo<T> getPageList(int page, int size) {
        PageHelper.startPage(page,size);
        List<T> list = mapper.select(null);
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return pageInfo;
    }


    public List<T> getListByParentId(Long parentId) {
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId", parentId);
        return mapper.selectByExample(example);
    }

    public int deleteByIds(List ids) {
        //wenti
        /*Example example = new Example(clazz);
        Criteria criteria = example.createCriteria();
        //指定对应的ID
        String fieldname ="id";
        //Class所有的属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //获取对应的注解
            Id annotation = field.getAnnotation(Id.class);
            if(annotation!=null){
                //如果注解不为空，说明是主键对应的属性
                fieldname = field.getName();
                System.out.println("fieldname:"+fieldname);
                break;
            }
        }

        //delete from tb_user where id in(1,23,434,4545)
        //编写删除条件，根据ID数组集合批量删除数据
        //criteria.andIn("id", ids);
        criteria.andIn(fieldname, ids);*/
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        String fieldName = "id";
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Id annotation = field.getAnnotation(Id.class);
            if(null!=annotation){
                fieldName=field.getName();
                break;
            }
        }
        criteria.andIn(fieldName,ids);
        int i = mapper.deleteByExample(example);
        return i;
    }
}
