package fr.ols.webappli.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ols.webappli.dao.IAdminDao;
import fr.ols.webappli.entities.Admin;
import fr.ols.webappli.service.AdminService;

@RestController
@RequestMapping("/admins")
public class AdminController extends AbstracEntitiesController<Admin, IAdminDao, AdminService> {

	public AdminController() {
		super(AdminService.class);
	}
}
