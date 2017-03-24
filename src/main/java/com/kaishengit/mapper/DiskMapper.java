package com.kaishengit.mapper;

import com.kaishengit.pojo.Disk;

import java.util.List;

/**
 * Created by 刘忠伟 on 2017/3/23.
 */
public interface DiskMapper {

    void save(Disk disk);

    Disk findById(Integer id);

    List<Disk> findByFid(Integer fid);

}
