package com.ae.teachercatalog.dao;

import com.ae.teachercatalog.model.SocialMedia;
import com.ae.teachercatalog.model.TeacherSocialMedia;

import java.util.List;

public class SocialMediaDaoImpl extends AbstractSession implements SocialMediaDao {

    @Override
    public void saveSocialMedia(final SocialMedia socialMedia) {
        getSession().persist(socialMedia);
    }

    @Override
    public List<SocialMedia> findAllSocialMedias() {
        return getSession().createQuery("from SocialMedia ").list();
    }

    @Override
    public void deleteSocialMedia(final Long idSocialMedia) {
        final SocialMedia socialMedia = findSocialMediaById(idSocialMedia);
        if (socialMedia != null) {
            getSession().delete(socialMedia);
        }
    }

    @Override
    public void updateSocialMedia(final SocialMedia socialMedia) {
        getSession().update(socialMedia);
    }

    @Override
    public SocialMedia findSocialMediaByName(final String name) {
        return (SocialMedia) getSession()
                .createQuery("from SocialMedia where name = :name")
                .setParameter("name", name);
    }

    @Override
    public SocialMedia findSocialMediaById(final Long idSocialMedia) {
        return getSession().get(SocialMedia.class, idSocialMedia);
    }

    @Override
    public TeacherSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname) {
        return null;
    }
}