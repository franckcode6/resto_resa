package fr.open.restau_resa.service.impl;

import org.springframework.stereotype.Service;

import fr.open.restau_resa.business.Menu;
import fr.open.restau_resa.dao.MenuDao;
import fr.open.restau_resa.service.MenuService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {
	
	private final MenuDao menuDao;
	
	@Override
	public Menu addMenu(Menu menu) {
		return menuDao.save(menu);
	}

}
