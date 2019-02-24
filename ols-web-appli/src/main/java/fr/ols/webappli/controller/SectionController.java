package fr.ols.webappli.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ols.webappli.dao.ISectionDao;
import fr.ols.webappli.entities.Section;
import fr.ols.webappli.service.SectionService;

@RestController
@RequestMapping("/sections")
public class SectionController extends AbstracEntitiesController<Section, ISectionDao, SectionService> {

	public SectionController() {
		super(SectionService.class);
	}
}
