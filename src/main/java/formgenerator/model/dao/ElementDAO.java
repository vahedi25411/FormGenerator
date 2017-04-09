package formgenerator.model.dao;

import java.util.List;

import formgenerator.model.FormElement;

public interface ElementDAO {
	FormElement getElement(Integer id);
	FormElement saveElement(FormElement element);
	boolean delete(FormElement element);
	List<FormElement> getElements(Integer pageId);
}
