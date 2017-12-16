package it.unifi.swa.dao;

import javax.enterprise.context.Dependent;

import it.unifi.swa.domain.Client;
import it.unifi.swa.domain.Pub;

@Dependent
public class PubDAO extends BaseDao<Pub>{

	protected PubDAO() {
		super(Pub.class);
	}

}
