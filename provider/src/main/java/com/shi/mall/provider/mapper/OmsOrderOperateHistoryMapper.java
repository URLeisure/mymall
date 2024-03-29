package com.shi.mall.provider.mapper;

import com.shi.api.model.OmsOrderOperateHistory;
import com.shi.api.model.OmsOrderOperateHistoryExample;
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

public interface OmsOrderOperateHistoryMapper {
    @SelectProvider(type=OmsOrderOperateHistorySqlProvider.class, method="countByExample")
    long countByExample(OmsOrderOperateHistoryExample example);

    @DeleteProvider(type=OmsOrderOperateHistorySqlProvider.class, method="deleteByExample")
    int deleteByExample(OmsOrderOperateHistoryExample example);

    @Delete({
        "delete from oms_order_operate_history",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into oms_order_operate_history (id, order_id, ",
        "operate_man, create_time, ",
        "order_status, note)",
        "values (#{id,jdbcType=BIGINT}, #{orderId,jdbcType=BIGINT}, ",
        "#{operateMan,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{orderStatus,jdbcType=INTEGER}, #{note,jdbcType=VARCHAR})"
    })
    int insert(OmsOrderOperateHistory record);

    @InsertProvider(type=OmsOrderOperateHistorySqlProvider.class, method="insertSelective")
    int insertSelective(OmsOrderOperateHistory record);

    @SelectProvider(type=OmsOrderOperateHistorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="operate_man", property="operateMan", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_status", property="orderStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<OmsOrderOperateHistory> selectByExample(OmsOrderOperateHistoryExample example);

    @Select({
        "select",
        "id, order_id, operate_man, create_time, order_status, note",
        "from oms_order_operate_history",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="operate_man", property="operateMan", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_status", property="orderStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    OmsOrderOperateHistory selectByPrimaryKey(Long id);

    @UpdateProvider(type=OmsOrderOperateHistorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OmsOrderOperateHistory record, @Param("example") OmsOrderOperateHistoryExample example);

    @UpdateProvider(type=OmsOrderOperateHistorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OmsOrderOperateHistory record, @Param("example") OmsOrderOperateHistoryExample example);

    @UpdateProvider(type=OmsOrderOperateHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OmsOrderOperateHistory record);

    @Update({
        "update oms_order_operate_history",
        "set order_id = #{orderId,jdbcType=BIGINT},",
          "operate_man = #{operateMan,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "order_status = #{orderStatus,jdbcType=INTEGER},",
          "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OmsOrderOperateHistory record);
}
