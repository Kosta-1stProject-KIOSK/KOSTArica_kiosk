package com.kiosk.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kiosk.member.model.dto.Member;
import com.kiosk.util.DBManager;

public class MemberDAOImpl implements MemberDAO {

	/**
	 * 회원정보 검색
	 * @param memberId (회원 PK 전화번호)
	 * @return MemberDTO (회원 정보가 담긴 객체)
	 */
	@Override
	public Member searchById(String memberId) {
		String sql = "SELECT * FROM member WHERE member_id = ?";
        try (Connection con = DBManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, memberId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Member(
                            rs.getString("member_id"),
                            rs.getString("member_name"),
                            rs.getString("birth"),
                            rs.getString("join_date"),
                            rs.getInt("stamp_count")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("[ERROR] 회원 검색 실패: " + e.getMessage());
        }
        return null;
	}

	
	
	
	
	/**
     * 전체 회원 목록 조회
     * @return 회원 목록(list)
     */
	@Override
	public List<Member> searchAll() {
		List<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM member";
        try (Connection con = DBManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Member(
                        rs.getString("member_id"),
                        rs.getString("member_name"),
                        rs.getString("birth"),
                        rs.getString("join_date"),
                        rs.getInt("stamp_count")
                ));
            }
        } catch (SQLException e) {
            System.out.println("[ERROR] 회원 전체 조회 실패: " + e.getMessage());
        }
        return list;
	}

	
	
	/**
     * 회원 등록
     * @param member (등록할 회원정보가 담긴 객체 MemberDTO member)
     */
	@Override
	public void insert(Member member) {
		String sql = "INSERT INTO member (member_id, member_name, birth, join_date, stamp_count) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, member.getMemberID());
            ps.setString(2, member.getMemberName());
            ps.setString(3, member.getBirth());
            ps.setString(4, member.getJoinDate());
            ps.setInt(5, member.getStampCount());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("[ERROR] 회원 등록 실패: " + e.getMessage());
        }
		
	}

	
	
	 /**
     * 회원 정보 수정
     * @param member (수정할 회원 정보 MemberDTO member)
     */
	@Override
	public void update(Member member) {
		String sql = "UPDATE member SET member_name=?, birth=?, join_date=?, stamp_count=? WHERE member_id=?";
        try (Connection con = DBManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, member.getMemberName());
            ps.setString(2, member.getBirth());
            ps.setString(3, member.getJoinDate());
            ps.setInt(4, member.getStampCount());
            ps.setString(5, member.getMemberID());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("[ERROR] 회원 수정 실패: " + e.getMessage());
        }
		
	}

	
	
	/**
     * 회원 삭제
     * @param memberId (삭제할 회원의 번호)
     */
	@Override
	public void delete(String memberId) {
		String sql = "DELETE FROM member WHERE member_id = ?";
        try (Connection con = DBManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, memberId);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("[ERROR] 회원 삭제 실패: " + e.getMessage());
        }
    }

	
}


