package cz.intelis.mobile.dataminerui.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ludek Cermak
 * 
 */
@XmlRootElement(name = "import")
public class Import {

	private Integer importId;
	private String cronExpression;
	private Boolean active;
	private String city;
	private String module;
	private String lang;
	private String url;
	private Integer lastDuration;
	private Date lastRun;
	private String cityName;
	
	public Import() {
		super();
	}

	public Integer getImportId() {
		return importId;
	}

	public void setImportId(Integer importId) {
		this.importId = importId;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getLastDuration() {
		return lastDuration;
	}

	public void setLastDuration(Integer lastDuration) {
		this.lastDuration = lastDuration;
	}

	public Date getLastRun() {
		return lastRun;
	}

	public void setLastRun(Date lastRun) {
		this.lastRun = lastRun;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "Import [importId=" + importId + ", cronExpression="
				+ cronExpression + ", active=" + active + ", city=" + city
				+ ", module=" + module + ", lang=" + lang + ", url=" + url
				+ ", lastDuration=" + lastDuration + ", lastRun=" + lastRun
				+ ", cityName=" + cityName + "]";
	}

}
