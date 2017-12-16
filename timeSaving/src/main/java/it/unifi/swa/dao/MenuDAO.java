package it.unifi.swa.dao;

import javax.enterprise.context.Dependent;

import it.unifi.swa.domain.Client;
import it.unifi.swa.domain.Menu;

@Dependent
public class MenuDAO extends BaseDao<Menu>{

	protected MenuDAO() {
		super(Menu.class);
	}

}
