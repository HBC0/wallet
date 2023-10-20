package com.example.demo.service;

import com.example.demo.Entity.Transaction;
import com.example.demo.mapper.TransactionMapper;
import com.example.demo.mapper.WalletMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TradeService {
    @Resource
    private WalletMapper walletMapper;

    @Resource
    private TransactionMapper transactionMapper;

    //消费
    public void spendMoney(int userId, BigDecimal amount) throws Exception {
        walletMapper.spendMoney(amount,userId);
        Transaction transaction = new Transaction();
        transaction.setTransactionType("消费");
        transaction.setUserId(userId);
        transaction.setCreateTime(LocalDateTime.now());
        transaction.setAmount(amount);
        Boolean result = transactionMapper.addTransaction(transaction);
        if (result == false) {
            throw new Exception("交易失败");
        }
    }

    //退款
    public void refundMoney(BigDecimal amount,int userId) throws Exception {
        walletMapper.spendMoney(amount,userId);
        Transaction transaction = new Transaction();
        transaction.setTransactionType("退款");
        transaction.setUserId(userId);
        transaction.setCreateTime(LocalDateTime.now());
        transaction.setAmount(amount);
        Boolean result =transactionMapper.addTransaction(transaction);
        if (result == false) {
            throw new Exception("交易失败");
        }
    }

    // 查询用户钱包金额变动明细的接口
    public List<Transaction> getTransactionHistory(int userId){
        List<Transaction> result = transactionMapper.getTransactionHistory(userId);
        return result;
    }

}
