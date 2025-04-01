package com.kiosk.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.kiosk.member.model.dto.MenuOption;
import com.kiosk.member.model.dto.Order;
import com.kiosk.member.model.dto.OrderDetail;
import com.kiosk.util.DBManager;

public class OrderDAOImpl implements OrderDAO {

	/**
	 * 주문 등록. 주문 상세 및 옵션 정보 포함.
	 * @param order (등록할 주문 정도 OrderDTO order)
	 */
	@Override
	public void insert(Order order) {
		String orderSql = "INSERT INTO orders (order_time, total_price, take_out, member_id, coupon_no) VALUES (?, ?, ?, ?, ?)";
        String detailSql = "INSERT INTO order_detail (order_detail_no, quantity, order_no, menu_no, basic_price, total_extra_fee) VALUES (?, ?, ?, ?, ?, ?)";
        String optionSql = "INSERT INTO menu_option (option_no, menu_no, temperature, size, shot, whipping, extra_fee, order_detail_no) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection con = null;
        PreparedStatement psOrder = null;
        PreparedStatement psDetail = null;
        PreparedStatement psOption = null;

        try {
            con = DBManager.getConnection();
            con.setAutoCommit(false);

            // 1. 주문 정보 삽입
            psOrder = con.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);
            psOrder.setString(1, order.getOrderTime());
            psOrder.setInt(2, order.getTotalPrice());
            psOrder.setBoolean(3, order.isTakeOut());
            psOrder.setString(4, order.getMemberId());
            if (order.getCouponNo() != null) {
                psOrder.setInt(5, order.getCouponNo());
            } else {
                psOrder.setNull(5, java.sql.Types.INTEGER);
            }
            psOrder.executeUpdate();

            int orderNo;
            try (var rs = psOrder.getGeneratedKeys()) {
                rs.next();
                orderNo = rs.getInt(1);
            }

            // 2. 주문 상세 삽입
            psDetail = con.prepareStatement(detailSql);
            psOption = con.prepareStatement(optionSql);
            for (OrderDetail detail : order.getOrderDetails()) {
                detail.setOrderNo(orderNo);

                psDetail.setInt(1, detail.getOrderDetailNo());
                psDetail.setInt(2, detail.getQuantity());
                psDetail.setInt(3, orderNo);
                psDetail.setInt(4, detail.getMenuNo());
                psDetail.setInt(5, detail.getBasicPrice());
                psDetail.setInt(6, detail.getTotalExtraFee());
                psDetail.executeUpdate();

                // 3. 옵션 정보 삽입 (있는 경우만)
                MenuOption opt = detail.getMenuOption();
                if (opt != null) {
                    psOption.setInt(1, opt.getOptionNo());
                    psOption.setInt(2, opt.getMenuNo());
                    psOption.setString(3, opt.getTemperature());
                    psOption.setString(4, opt.getSize());
                    psOption.setInt(5, opt.getShot());
                    psOption.setInt(6, opt.getWhipping());
                    psOption.setInt(7, opt.getExtraFee());
                    psOption.setInt(8, detail.getOrderDetailNo());
                    psOption.executeUpdate();
                }
            }

            con.commit();

        } catch (SQLException e) {
            try {
                if (con != null) con.rollback();
            } catch (SQLException e1) {
                System.out.println("[ERROR] rollback 실패: " + e1.getMessage());
            }
            System.out.println("[ERROR] 주문 등록 실패: " + e.getMessage());
        } finally {
            DBManager.dbClose(null, psOption);
            DBManager.dbClose(null, psDetail);
            DBManager.dbClose(null, psOrder);
            DBManager.dbClose(con, null);
        }
    }
		
	

	
	
	/**
     * 주문번호로 주문 정보 조회
     * @param orderNo 주문번호
     * @return 주문정보(OrderDTO)
     */
	@Override
	public Order searchById(int orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
     * 특정 회원의 주문 목록을 조회
     * @param memberId (회원번호)
     * @return 해당 회원의 주문 리스트(List<OrderDTO>)
     */
	@Override
	public List<Order> searchByMember(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
     * 전체 주문 조회
     * @return 전체 주문 리스트(List<OrderDTO>)
     */
	@Override
	public List<Order> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
     * 이건 넣을지 말지 고민중! 주문을 삭제할 필요가 있나?
     * 주문 삭제
     * @param orderNo (삭제할 주문 번호)
     */
	@Override
	public void delete(int orderNo) {
		// TODO Auto-generated method stub
		
	}

}




