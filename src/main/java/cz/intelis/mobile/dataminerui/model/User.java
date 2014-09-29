package cz.intelis.mobile.dataminerui.model;

import java.util.Date;

/**
 * @author Ludek Cermak
 * 
 */
public class User {

	private Integer userId;
	private String userName;
	private String userEmail;
	private String userPwd;
	private Integer catNum06;
	private Integer catNum0710;
	private Integer catNum1116;
	private Integer catNum16;
	private Date createTime;

	public User() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Integer getCatNum06() {
		return catNum06;
	}

	public void setCatNum06(Integer catNum06) {
		this.catNum06 = catNum06;
	}

	public Integer getCatNum0710() {
		return catNum0710;
	}

	public void setCatNum0710(Integer catNum0710) {
		this.catNum0710 = catNum0710;
	}

	public Integer getCatNum1116() {
		return catNum1116;
	}

	public void setCatNum1116(Integer catNum1116) {
		this.catNum1116 = catNum1116;
	}

	public Integer getCatNum16() {
		return catNum16;
	}

	public void setCatNum16(Integer catNum16) {
		this.catNum16 = catNum16;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userEmail=");
		builder.append(userEmail);
		builder.append(", userPwd=");
		builder.append(userPwd);
		builder.append(", catNum06=");
		builder.append(catNum06);
		builder.append(", catNum0710=");
		builder.append(catNum0710);
		builder.append(", catNum1116=");
		builder.append(catNum1116);
		builder.append(", catNum16=");
		builder.append(catNum16);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}

}
