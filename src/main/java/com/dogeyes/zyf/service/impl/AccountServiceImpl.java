package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.mapper.AccountMapper;
import com.dogeyes.zyf.pojo.Account;
import com.dogeyes.zyf.pojo.AccountExample;
import com.dogeyes.zyf.resource.account.AccountSignupResource;
import com.dogeyes.zyf.resource.common.PageParamResource;
import com.dogeyes.zyf.service.AccountService;
import com.dogeyes.zyf.util.PageSortHelper;
import com.dogeyes.zyf.util.PropertyMapperUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
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

    @Value("${web.upload-path}")
    private String uploadPath;

    @Value("${web.avatar-path}")
    private String avatarPath;

    @Value("${web.default-avatar}")
    private String defaultAvatar;

    @Override
    public List<Account> login(String email, String pwd) {
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email).andPwdEqualTo(pwd);

        return accountMapper.selectByExample(example);
    }

    @Override
    public Object signup(AccountSignupResource resource) {
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(resource.getEmail());
        if (!accountMapper.selectByExample(example).isEmpty()) {
            return 1;
        }
        Account account = PropertyMapperUtil.map(resource, Account.class);
        if (account != null) {
            account.setCreateTime(new Date());
            account.setUpdateTime(new Date());
            account.setStats(0);
            account.setBalance(BigDecimal.ZERO);
            account.setHeadPic(uploadPath + avatarPath + defaultAvatar);
            accountMapper.insertSelective(account);
            AccountExample example1 = new AccountExample();
            AccountExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andEmailEqualTo(account.getEmail());
            return accountMapper.selectByExample(example1).get(0);
        }
        return 0;
    }

    @Override
    public Account findAccountById(Long id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean existsEmail(String email) {
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        return !accountMapper.selectByExample(example).isEmpty();
    }

    @Override
    public Account update(Account account) {
        account.setUpdateTime(new Date());
        int i = accountMapper.updateByPrimaryKeySelective(account);
        if (i == 0) return null;
        return accountMapper.selectByPrimaryKey(account.getId());
    }

    @Override
    public PageInfo<Account> listAll(PageParamResource page) {
        AccountExample example = new AccountExample();
        PageSortHelper.pageAndSort(page, Account.class);
        List<Account> accounts = accountMapper.selectByExample(example);

        return new PageInfo<>(accounts);
    }
}
