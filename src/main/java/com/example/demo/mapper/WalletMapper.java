package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

@Mapper
public interface WalletMapper {
    //查询余额
    @Select("select balance from wallets where user_id = #{userId}")
    BigDecimal selectBalance(int userId);

    //消费,提现
    @Update("UPDATE Wallets SET balance = balance - #{amount} WHERE user_id = #{userId}")
    Boolean spendMoney(BigDecimal amount,int userId);

    //退款，充值
    @Update("UPDATE Wallets SET balance = balance +  #{amount} WHERE user_id = #{userId}")
    Boolean refundMoney(BigDecimal amount,int userId);

}
