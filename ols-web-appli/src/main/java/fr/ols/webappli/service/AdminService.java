package fr.ols.webappli.service;

import org.springframework.stereotype.Service;

import fr.ols.webappli.dao.IAdminDao;
import fr.ols.webappli.entities.Admin;

@Service
public class AdminService extends AbstractEntitiesService<Admin, IAdminDao> {

	public AdminService() {
		super(Admin.class, IAdminDao.class);
	}
}

