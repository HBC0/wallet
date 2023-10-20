package com.example.demo.mapper;

import com.example.demo.Entity.Transaction;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TransactionMapper {

    //查询明细
    @Select("SELECT * FROM Transactions WHERE user_id = #{userId} order by create_time desc")
    @Results({
            @Result(column="user_id",property="userId"),
            @Result(column="transaction_type",property="transactionType"),
            @Result(column="create_time",property="createTime")
    })
    List<Transaction> getTransactionHistory(int userId);

    //添加记录
    @Insert("insert into transactions (user_id , transaction_type, create_time, amount) " +
            "value (#{userId},#{transactionType},#{createTime},#{amount})")
    Boolean addTransaction(Transaction transaction);

}
