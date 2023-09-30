package businessLogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBean.HangSua;

public class HangSuaBL {
	public static List<HangSua> docTatCa() {
		List<HangSua> dshs = null;
		try (Connection kn = CSDL.getKetNoi()) {
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery("select*from hang_sua");
			dshs = new ArrayList<>();
			while (rs.next()) {
				HangSua hs = new HangSua();
				hs.setMaHangSua(rs.getString("ma_hang_sua"));
				hs.setTenHangSua(rs.getString("ten_hang_sua"));
				hs.setDiaChi(rs.getString("dia_chi"));
				hs.setDienThoai(rs.getString("dien_thoai"));
				hs.setEmail(rs.getString("email"));
				dshs.add(hs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dshs;
	}
}
