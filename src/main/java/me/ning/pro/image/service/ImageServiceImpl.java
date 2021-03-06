package me.ning.pro.image.service;

import me.ning.pro.image.entity.Image;
import me.ning.pro.image.dao.ImageDao;
import me.ning.pro.util.img.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final Logger logger = LoggerFactory.getLogger(ImageService.class);


    @Autowired
    private ImageDao imageDao;

    @Override
    public List<Image> allImages() {
        return imageDao.allImages();
    }

    @Override
    public boolean addImage(String url) {
        Integer result = imageDao.addImage(new Image(url));
        logger.info("添加结果："+result);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean hadImage(String url) {
        List<Image> images = imageDao.hadImage(ImageUtil.Id(url));
        boolean result = (images == null || images.isEmpty());
        String canSave = result ?"可以":"不可以";
        logger.info("可以存吗:"+canSave);
        return !result;
    }



}
