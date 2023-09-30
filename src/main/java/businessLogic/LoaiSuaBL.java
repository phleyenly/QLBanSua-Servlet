package businessLogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBean.LoaiSua;

public class LoaiSuaBL {
	public static List<LoaiSua> docTatCa() {
		List<LoaiSua> dsls = null;
		try (Connection kn = CSDL.getKetNoi()) {
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery("select * from loai_sua");
			dsls = new ArrayList<>();
			while (rs.next()) {
				LoaiSua ls = new LoaiSua();
				ls.setMaLoaiSua(rs.getString("ma_loai_sua"));
				ls.setTenLoai(rs.getString("ten_loai"));
				dsls.add(ls);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return dsls;
	}
}
