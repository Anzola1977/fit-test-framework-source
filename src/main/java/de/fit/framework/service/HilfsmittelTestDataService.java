package de.fit.framework.service;
import de.fit.framework.api.*;import de.fit.framework.domain.*;import de.fit.framework.generation.*;import de.fit.framework.persistence.dao.*;import org.springframework.stereotype.Service;
@Service public class HilfsmittelTestDataService{private final HilfsmittelGenerator generator;private final HilfsmittelCaseDao dao;public HilfsmittelTestDataService(HilfsmittelGenerator g,HilfsmittelCaseDao d){generator=g;dao=d;}public Long create(HilfsmittelScenario s){return dao.save(generator.generate(s));}public HilfsmittelCaseData read(Long id){return dao.read(id);}}
