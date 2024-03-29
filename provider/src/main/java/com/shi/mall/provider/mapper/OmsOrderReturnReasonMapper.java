package com.shi.mall.provider.mapper;

import com.shi.api.model.OmsOrderReturnReason;
import com.shi.api.model.OmsOrderReturnReasonExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OmsOrderReturnReasonMapper {
    @SelectProvider(type=OmsOrderReturnReasonSqlProvider.class, method="countByExample")
    long countByExample(OmsOrderReturnReasonExample example);

    @DeleteProvider(type=OmsOrderReturnReasonSqlProvider.class, method="deleteByExample")
    int deleteByExample(OmsOrderReturnReasonExample example);

    @Delete({
        "delete from oms_order_return_reason",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into oms_order_return_reason (id, name, ",
        "sort, status, create_time)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(OmsOrderReturnReason record);

    @InsertProvider(type=OmsOrderReturnReasonSqlProvider.class, method="insertSelective")
    int insertSelective(OmsOrderReturnReason record);

    @SelectProvider(type=OmsOrderReturnReasonSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OmsOrderReturnReason> selectByExample(OmsOrderReturnReasonExample example);

    @Select({
        "select",
        "id, name, sort, status, create_time",
        "from oms_order_return_reason",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OmsOrderReturnReason selectByPrimaryKey(Long id);

    @UpdateProvider(type=OmsOrderReturnReasonSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OmsOrderReturnReason record, @Param("example") OmsOrderReturnReasonExample example);

    @UpdateProvider(type=OmsOrderReturnReasonSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OmsOrderReturnReason record, @Param("example") OmsOrderReturnReasonExample example);

    @UpdateProvider(type=OmsOrderReturnReasonSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OmsOrderReturnReason record);

    @Update({
        "update oms_order_return_reason",
        "set name = #{name,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OmsOrderReturnReason record);
}
