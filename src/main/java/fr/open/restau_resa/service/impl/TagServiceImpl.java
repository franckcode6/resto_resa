package fr.open.restau_resa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.open.restau_resa.business.Tag;
import fr.open.restau_resa.dao.TagDao;
import fr.open.restau_resa.service.TagService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {
	
	private final TagDao tagDao;
	
	@Override
	public List<Tag> getAllTags() {
		return tagDao.findAll();
	}
}
