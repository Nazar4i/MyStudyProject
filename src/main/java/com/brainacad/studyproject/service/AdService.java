package com.brainacad.studyproject.service;

import com.brainacad.studyproject.data.domain.Ad;

import java.util.Collection;

/**
 * Created by ${UArabei}.
 */
public interface AdService {

    Collection<Ad> getAllAds();

    Ad getAdById(int id);

    int addAd(Ad ad);

    boolean update(Ad Ad);

    boolean delete(int id);

    Ad getAdByName(String username);
}
