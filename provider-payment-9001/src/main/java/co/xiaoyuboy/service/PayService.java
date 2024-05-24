package co.xiaoyuboy.service;

import co.xiaoyuboy.entities.Pay;

import java.util.List;

public interface PayService {
    int add(Pay pay);
    int delete(Integer id);
    int update(Pay pay);
    Pay getById(Integer id);
    List<Pay> getAll();

}
