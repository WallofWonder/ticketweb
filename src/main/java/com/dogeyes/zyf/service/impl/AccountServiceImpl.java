package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.mapper.AccountMapper;
import com.dogeyes.zyf.pojo.Account;
import com.dogeyes.zyf.pojo.AccountExample;
import com.dogeyes.zyf.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-17 19:14
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountMapper accountMapper;

    @Override
    public List<Account> login(String mobile, String pwd) {
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile).andPwdEqualTo(pwd);

        return accountMapper.selectByExample(example);
    }
}
