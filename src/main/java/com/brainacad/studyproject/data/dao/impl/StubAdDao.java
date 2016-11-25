package com.brainacad.studyproject.data.dao.impl;

import com.brainacad.studyproject.data.core.StubDataHolder;
import com.brainacad.studyproject.data.dao.AdDao;
import com.brainacad.studyproject.data.domain.Ad;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by ${UArabei}.
 */
public class StubAdDao implements AdDao {
    @Override
    public Ad get(int id) {
        Collection<Ad> ads = StubDataHolder.getAds();
        for (Ad ad : ads) {
            if (ad.getAdID() == id) {
                return ad;
            }
        }
        return null;
    }

    @Override
    public int add(Ad entity) {
        return StubDataHolder.add(entity);
    }

    @Override
    public boolean delete(int id) {
        Collection<Ad> ads = StubDataHolder.getAds();
        Iterator<Ad> iterator = ads.iterator();
        while (iterator.hasNext()) {
            Ad ad = iterator.next();
            if (ad.getAdID()== id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(Ad entity) {
        Collection<Ad> ads = StubDataHolder.getAds();
        for (Ad ad : ads) {
            if (ad.getAdID() == entity.getAdID()) {
                ad.setShortDesc(entity.getShortDesc());
                ad.setFullDesc(entity.getFullDesc());
                ad.setType(entity.getType());
                ad.setUserId(entity.getUserId());
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<Ad> getAll() {
        return StubDataHolder.getAds();
    }

    @Override
    public Ad getAdByName(String name) {
        Collection<Ad> ads = StubDataHolder.getAds();
        for (Ad ad : ads) {
            if (ad.getShortDesc().equals(name)) return ad;
        }
        return null;
    }
}
