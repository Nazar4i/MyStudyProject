package com.brainacad.studyproject.data.dao;

import com.brainacad.studyproject.data.domain.Ad;

/**
 * Created by ${UArabei}.
 */
public interface AdDao extends Crud<Ad>{
    Ad getAdByName(String name);
}
