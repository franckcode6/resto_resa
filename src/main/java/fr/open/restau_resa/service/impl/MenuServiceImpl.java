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
	public Menu getMenu(Long id) {
		return menuDao.findById(id).orElse(null);
	}

	@Override
	public Menu addMenu(Menu menu) {
		return menuDao.save(menu);
	}

	@Override
	public void deleteMenu(Long id) {
		menuDao.deleteById(id);
	}

	@Override
	public Menu modifyMenu(Long id, String name, String description, float price) {

		Menu menu = menuDao.findById(id).orElse(null);

		menu.setName(name);
		menu.setDescription(description);
		menu.setPrice(price);

		return menuDao.save(menu);
	}
}
