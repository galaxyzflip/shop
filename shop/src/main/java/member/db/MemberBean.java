package member.db;

import java.sql.Timestamp;

public class MemberBean {

	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberBirthday;
	private String memberMale;
	private String memberEmail;
	private String memberEmailGet;
	private String memberMobile;
	private String memberMobileGet;
	private String memberPhone;

	private String memberZipcode;
	private String memberAddr1;
	private String memberAddr2;
	private int memberAdmin;
	private Timestamp memberJoinDate;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBirthday() {
		return memberBirthday;
	}

	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
	}

	public String getMemberMale() {
		return memberMale;
	}

	public void setMemberMale(String memberMale) {
		this.memberMale = memberMale;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberEmailGet() {
		return memberEmailGet;
	}

	public void setMemberEmailGet(String memberEmailGet) {
		this.memberEmailGet = memberEmailGet;
	}

	public String getMemberMobile() {
		return memberMobile;
	}

	public void setMemberMobile(String memberMobile) {
		this.memberMobile = memberMobile;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberMobileGet() {
		return memberMobileGet;
	}

	public void setMemberMobileGet(String memberMobileGet) {
		this.memberMobileGet = memberMobileGet;
	}

	public String getMemberZipcode() {
		return memberZipcode;
	}

	public void setMemberZipcode(String memberZipcode) {
		this.memberZipcode = memberZipcode;
	}

	public String getMemberAddr1() {
		return memberAddr1;
	}

	public void setMemberAddr1(String memberAddr1) {
		this.memberAddr1 = memberAddr1;
	}

	public String getMemberAddr2() {
		return memberAddr2;
	}

	public void setMemberAddr2(String memberAddr2) {
		this.memberAddr2 = memberAddr2;
	}

	public int getMemberAdmin() {
		return memberAdmin;
	}

	public void setMemberAdmin(int memberAdmin) {
		this.memberAdmin = memberAdmin;
	}

	public Timestamp getMemberJoinDate() {
		return memberJoinDate;
	}

	public void setMemberJoinDate(Timestamp memberJoinDate) {
		this.memberJoinDate = memberJoinDate;
	}

}
