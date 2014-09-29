package cz.intelis.mobile.dataminerui.ui;

import java.util.List;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import cz.intelis.mobile.dataminerui.model.Import;
import cz.intelis.mobile.dataminerui.service.ImportService;

/**
 * @author Ludek Cermak
 * 
 */
@VariableResolver(DelegatingVariableResolver.class)
public class ImportViewModel {

	@WireVariable
	private ImportService importService;
	private List<Import> importList;

	public List<Import> getImportList() {
		return importList;
	}

	public void setImportList(List<Import> importList) {
		this.importList = importList;
	}

	@Init
	public void init() {
		importList = importService.getAll();
	}

}