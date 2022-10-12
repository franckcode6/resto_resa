package fr.open.restau_resa.service;

import fr.open.restau_resa.business.Menu;

public interface MenuService {

	Menu getMenu(Long id);

	Menu addMenu(Menu menu);

	Menu modifyMenu(Long id, String name, String description, float price);

	void deleteMenu(Long id);
}
