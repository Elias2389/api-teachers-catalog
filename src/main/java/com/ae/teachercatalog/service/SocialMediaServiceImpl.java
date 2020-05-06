package com.ae.teachercatalog.service;

import com.ae.teachercatalog.dao.SocialMediaDao;
import com.ae.teachercatalog.model.SocialMedia;
import com.ae.teachercatalog.model.TeacherSocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("socialMediaService")
@Transactional
public class SocialMediaServiceImpl implements SocialMediaService {

    @Autowired
    private SocialMediaDao socialMediaDao;

    @Override
    public void saveSocialMedia(final SocialMedia socialMedia) {
        socialMediaDao.saveSocialMedia(socialMedia);
    }

    @Override
    public List<SocialMedia> findAllSocialMedias() {
        return socialMediaDao.findAllSocialMedias();
    }

    @Override
    public void deleteSocialMedia(final Long idSocialMedia) {
        socialMediaDao.deleteSocialMedia(idSocialMedia);
    }

    @Override
    public void updateSocialMedia(final SocialMedia socialMedia) {
        socialMediaDao.updateSocialMedia(socialMedia);
    }

    @Override
    public SocialMedia findSocialMediaByName(final String name) {
        return socialMediaDao.findSocialMediaByName(name);
    }

    @Override
    public SocialMedia findSocialMediaById(final Long idSocialMedia) {
        return socialMediaDao.findSocialMediaById(idSocialMedia);
    }

    @Override
    public TeacherSocialMedia findSocialMediaByIdAndName(final Long idSocialMedia, String nickname) {
        return socialMediaDao.findSocialMediaByIdAndName(idSocialMedia, nickname);
    }
}
