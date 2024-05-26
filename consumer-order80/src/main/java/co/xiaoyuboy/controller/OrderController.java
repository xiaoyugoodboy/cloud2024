package co.xiaoyuboy.controller;


import co.xiaoyuboy.entities.Pay;
import co.xiaoyuboy.entities.PayDTO;
import co.xiaoyuboy.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Smile
 * @Date: 2024-05-26 10:55
 * @Description:
 */
@RestController
public class OrderController {
//    public static final String PaymentSrv_URL = "http://localhost:9001";//先写死，硬编码
    public static final String PaymentSrv_URL = "http://provider-payment-9001";//微服务调用 consul
    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData<Pay> getPayInfo(@PathVariable("id") Integer id){
        ResultData forObject = restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class);
        System.out.println(forObject);
        return   restTemplate.getForObject(PaymentSrv_URL+"/pay/get/"+id,ResultData.class);
    }
    @GetMapping("/consumer/pay/add")
    public ResultData<Pay> addPay(PayDTO payDTO){

       // return  restTemplate.postForObject(PaymentSrv_URL + "/pay/add", ResultData.class,payDTO);
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add",payDTO,ResultData.class);
    }



}
