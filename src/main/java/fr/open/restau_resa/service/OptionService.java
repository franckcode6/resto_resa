package fr.open.restau_resa.service;

import java.util.List;

import fr.open.restau_resa.business.Option;

public interface OptionService {

	List<Option> recupererOptions();

	Option getOption(Long id);
}
