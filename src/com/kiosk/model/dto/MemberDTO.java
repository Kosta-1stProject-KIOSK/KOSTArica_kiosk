package com.kiosk.model.dto;

import java.time.LocalDate;

/**
 * 회원정보 member 테이블
 */
public class MemberDTO {

	private String memberID;
	private String memberName;
    private LocalDate birth;
    private LocalDate joinDate;
    private int stampCount;
    
    
    
    //Constructor
	public MemberDTO(String memberID, String memberName, LocalDate birth, LocalDate joinDate, int stampCount) {
		super();
		this.memberID = memberID;
		this.memberName = memberName;
		this.birth = birth;
		this.joinDate = joinDate;
		this.stampCount = stampCount;
	}


	//getter, setter
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public int getStampCount() {
		return stampCount;
	}
	public void setStampCount(int stampCount) {
		this.stampCount = stampCount;
	}


	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberDTO [memberID=");
		builder.append(memberID);
		builder.append(", memberName=");
		builder.append(memberName);
		builder.append(", birth=");
		builder.append(birth);
		builder.append(", joinDate=");
		builder.append(joinDate);
		builder.append(", stampCount=");
		builder.append(stampCount);
		builder.append("]");
		return builder.toString();
	}
    
	
	
    
    
    
}
