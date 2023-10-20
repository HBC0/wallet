package com.example.demo.Controller;

import com.example.demo.Entity.Transaction;
import com.example.demo.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TradeService tradeService;

    @PostMapping("/spend")
    public Map<String,Object> spendMoney(@RequestParam int userId,@RequestParam("amount") BigDecimal amount){

        Map<String,Object> result = new HashMap<>();
        try {
            tradeService.spendMoney(userId,amount);
            result.put("code", 0);
            result.put("message", "success");
            result.put("data", null);
        }catch (Exception e){
            result.put("code", -1);
            result.put("message", e.getMessage());
            result.put("data", null);
        }
        return result;
    }

    @PostMapping("/refund")
    public Map<String,Object> refundMoney(@RequestParam int userId,@RequestParam("amount") BigDecimal amount){

        Map<String,Object> result = new HashMap<>();
        try {
            tradeService.refundMoney(amount,userId);
            result.put("code", 0);
            result.put("message", "success");
            result.put("data", null);
        }catch (Exception e){
            result.put("code", -1);
            result.put("message", e.getMessage());
            result.put("data", null);
        }
        return result;
    }

    //查询用户钱包金额变动明细的接口
    @GetMapping("/history")
    public Map<String,Object> getTransactionHistory(@RequestParam int userId){

        Map<String,Object> result = new HashMap<>();
        try {
            List<Transaction> list =tradeService.getTransactionHistory(userId);
            result.put("code", 0);
            result.put("message", "success");
            result.put("data",list);
        }catch (Exception e){
            result.put("code", -1);
            result.put("message", e.getMessage());
            result.put("data", null);
        }
        return result;
    }

}
