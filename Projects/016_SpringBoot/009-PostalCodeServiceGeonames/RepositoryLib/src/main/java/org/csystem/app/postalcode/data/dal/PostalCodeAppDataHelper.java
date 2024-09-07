package org.csystem.app.postalcode.data.dal;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.postalcode.data.entity.PostalCode;
import org.csystem.app.postalcode.data.entity.PostalCodeInfo;
import org.csystem.app.postalcode.data.entity.PostalCodeQueryInfo;
import org.csystem.app.postalcode.data.repository.IPostalCodeInfoRepository;
import org.csystem.app.postalcode.data.repository.IPostalCodeQueryInfoRepository;
import org.csystem.app.postalcode.data.repository.IPostalCodeRepository;
import org.csystem.data.exception.repository.RepositoryException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
 import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class PostalCodeAppDataHelper {
    private final IPostalCodeRepository m_postalCodeRepository;
    private final IPostalCodeInfoRepository m_postalCodeInfoRepository;
    private final IPostalCodeQueryInfoRepository m_postalCodeQueryInfoRepository;

    public PostalCodeAppDataHelper(IPostalCodeRepository postalCodeRepository, IPostalCodeInfoRepository postalCodeInfoRepository, IPostalCodeQueryInfoRepository postalCodeQueryInfoRepository)
    {
        m_postalCodeRepository = postalCodeRepository;
        m_postalCodeInfoRepository = postalCodeInfoRepository;
        m_postalCodeQueryInfoRepository = postalCodeQueryInfoRepository;
    }

    private void savePostalCodesCallback(PostalCodeInfo postalCodeInfo, PostalCode postalCode)
    {
        postalCodeInfo.postalCode = postalCode;

        m_postalCodeInfoRepository.save(postalCodeInfo);
    }

    public void savePostalCodeQueryInfo(PostalCode postalCode)
    {
        try {
            log.info("PostalCodeAppDataHelper.savePostalCodeQueryInfo");

            var postalCodeQueryInfo = new PostalCodeQueryInfo();

            postalCodeQueryInfo.postalCode = postalCode;
            postalCodeQueryInfo.queryDatetime = postalCode.firstQueryDateTime;

            m_postalCodeQueryInfoRepository.save(postalCodeQueryInfo);
        }
        catch (Throwable ex) {
            log.error("PostalCodeAppDataHelper.savePostalCodeQueryInfo -> Exception occurred : {}", ex.getMessage());
            throw new RepositoryException("PostalCodeAppDataHelper.savePostalCodeQueryInfo", ex);
        }
    }

    public void savePostalCodeQueryInfo(String postalCode)
    {
        try {
            log.info("PostalCodeAppDataHelper.savePostalCodeQueryInfo(String postalCode)");

            var opt = m_postalCodeRepository.findById(postalCode);

            if (opt.isEmpty())
                throw new SQLException("%s not found".formatted(postalCode));

            var postalCodeQueryInfo = new PostalCodeQueryInfo();
            var p = opt.get();

            postalCodeQueryInfo.postalCode = p;
            postalCodeQueryInfo.queryDatetime = p.firstQueryDateTime;

            m_postalCodeQueryInfoRepository.save(postalCodeQueryInfo);
        }
        catch (Throwable ex) {
            log.error("PostalCodeAppDataHelper.savePostalCodeQueryInfo(String postalCode) -> Exception occurred : {}", ex.getMessage());
            throw new RepositoryException("PostalCodeAppDataHelper.savePostalCodeQueryInfo(String postalCode)", ex);
        }
    }

    @Transactional
    public void savePostalCodes(PostalCode postalCode, Set<PostalCodeInfo> postalCodeInfo)
    {
        try {
            log.info("PostalCodeAppDataHelper.savePostalCodes");

            var pCode = m_postalCodeRepository.save(postalCode);
            var postalCodeQueryInfo = new PostalCodeQueryInfo();

            postalCodeQueryInfo.postalCode = pCode;
            postalCodeQueryInfo.queryDatetime = pCode.firstQueryDateTime;

            m_postalCodeQueryInfoRepository.save(postalCodeQueryInfo);

            postalCodeInfo.forEach(p -> savePostalCodesCallback(p, pCode));
        }
        catch (Throwable ex) {
            log.error("PostalCodeAppDataHelper.savePostalCodes -> Exception occurred : {}", ex.getMessage());
            throw new RepositoryException("PostalCodeAppDataHelper.savePostalCodes", ex);
        }
    }

    public List<PostalCodeInfo> findPostalCodeInfoByCity(String cityName)
    {
        try {
            log.info("PostalCodeAppDataHelper.findPostalCodeInfoByCity: {}", cityName);
            return m_postalCodeInfoRepository.findByCity(cityName);
        }
        catch (Throwable ex) {
            log.error("PostalCodeAppDataHelper.findPostalCodeInfoByCity -> Exception occurred : {}", ex.getMessage());
            throw new RepositoryException("PostalCodeAppDataHelper.findPostalCodeInfoByCity", ex);
        }
    }
}
