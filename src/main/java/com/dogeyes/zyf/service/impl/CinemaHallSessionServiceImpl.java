package com.dogeyes.zyf.service.impl;

import com.dogeyes.zyf.mapper.CinemaHallSessionMapper;
import com.dogeyes.zyf.mapper.CustomCinemaHallSessionMapper;
import com.dogeyes.zyf.resource.common.PageParamResource;
import com.dogeyes.zyf.resource.hallsession.HallSessionReqAdmin;
import com.dogeyes.zyf.resource.hallsession.HallSessionReqResource;
import com.dogeyes.zyf.resource.hallsession.HallSessionResAdmin;
import com.dogeyes.zyf.resource.hallsession.HallSessionResResource;
import com.dogeyes.zyf.service.CinemaHallSessionService;
import com.dogeyes.zyf.util.DateTimeUtil;
import com.dogeyes.zyf.util.PageSortHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZYF
 * @create 2021-4-19 10:40
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class CinemaHallSessionServiceImpl implements CinemaHallSessionService {
    @Resource
    CinemaHallSessionMapper hallSessionMapper;

    @Resource
    CustomCinemaHallSessionMapper customHallSessionMapper;

    @Override
    public List<HallSessionResResource> listShowBy(HallSessionReqResource resource) {
        List<HallSessionResResource> res = new ArrayList<>();
        String curDate = DateTimeUtil.getCurDateTime("M月d日");
        String curTime = DateTimeUtil.getCurDateTime("HH:mm");
        List<HallSessionResResource> resAll = customHallSessionMapper.listShowBy(resource);
        if (!resAll.isEmpty()) {
            int startIndex = 0;
            if (resource.getShowdate().equals(curDate)) {
                for (int i = 0; i < resAll.size(); i++) {
                    if (resAll.get(i).getStartTime().compareTo(curTime) >= 0) {
                        startIndex = i;
                        break;
                    }
                }
            }
            res = resAll.subList(startIndex, resAll.size());
        }
        return res;
    }

    @Override
    public PageInfo<List<HallSessionResResource>> listShowAdminBy(HallSessionReqAdmin resource, PageParamResource page) {
        PageSortHelper.pageAndSort(page, HallSessionResResource.class);
        List<HallSessionResAdmin> list = customHallSessionMapper.listShowAdmin(resource);
        return new PageInfo(list);
    }

    @Override
    public List<String> getShowDates(long movieid) {
        String curDate = DateTimeUtil.getCurDateTime("M月d日");
        List<String> res;
        List<String> resAll = customHallSessionMapper.getShowDates(movieid);
        int startIndex = resAll.size();
        for (int i = 0; i < resAll.size(); i++) {
            if (resAll.get(i).compareTo(curDate) >= 0) {
                startIndex = i;
                break;
            }
        }
        res = resAll.subList(startIndex, resAll.size());
        return res;
    }

    @Override
    public HallSessionResResource getById(long id) {
        return customHallSessionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<String> getShowDatesAdmin(long cinemaid) {
        return customHallSessionMapper.getShowDatesAdmin(cinemaid);
    }
}
