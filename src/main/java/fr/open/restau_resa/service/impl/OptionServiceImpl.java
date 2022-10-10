package fr.open.restau_resa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.open.restau_resa.business.Option;
import fr.open.restau_resa.dao.OptionDao;
import fr.open.restau_resa.service.OptionService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OptionServiceImpl implements OptionService {
	
	private final OptionDao optionDao;
	
	@Override
	public List<Option> recupererOptions() {
		return optionDao.findAll();
	}

	@Override
	public Option getOption(Long id) {
		return optionDao.findById(id).orElse(null);
	}
}
