package formgenerator.model.dao;

import java.util.List;

import formgenerator.model.Form;

public interface FormDAO {
	Form getForm(Integer id);
	Form saveForm(Form form);
	boolean delete(Form form);
	List<Form> getForms();
}
