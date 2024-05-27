package co.xiaoyuboy.controller;


import co.xiaoyuboy.apis.PayFeignApi;
import co.xiaoyuboy.entities.Pay;
import co.xiaoyuboy.entities.PayDTO;
import co.xiaoyuboy.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Smile
 * @Date: 2024-05-26 10:55
 * @Description:
 */
@RestController
public class OrderController {
    @Resource
    private PayFeignApi payFeignApi;
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData<Pay> getPayInfo(@PathVariable("id") Integer id){
        return   payFeignApi.getPay(id);
    }
    @GetMapping("/consumer/pay/add")
    public ResultData addPay( PayDTO payDTO){
        System.out.println("payDTO = " + payDTO);
//      return ResultData.success(payFeignApi.addPay(payDTO));
        return payFeignApi.addPay(payDTO);
    }
    @PostMapping("/consumer/pay/addplus")
    public ResultData addPayPlus(@RequestBody PayDTO payDTO){
        System.out.println("payDTO = " + payDTO);
//      return ResultData.success(payFeignApi.addPay(payDTO));
        return payFeignApi.addPay(payDTO);
    }
    @GetMapping("/consumer/pay/info")
    public ResultData<String> getInfo(){
        ResultData<String> info = payFeignApi.getInfo();
        System.out.println("info = " + info);
        return info;
    }



}
