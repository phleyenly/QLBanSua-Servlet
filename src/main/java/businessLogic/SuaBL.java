package businessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBean.Sua;

public class SuaBL {
//	public static List<Sua> docTatCa() {
//		List<Sua> dsSua = null;
//		try (Connection kn = Database.getKetNoi()) {
//			Statement stm = kn.createStatement();
//			ResultSet rs = stm.executeQuery("select*from sua");
//			dsSua = new ArrayList<>();
//			while (rs.next()) {
//				Sua s = new Sua();
//				s.setMaSua(rs.getString("ma_sua"));
//				s.setTenSua(rs.getString("ten_sua"));
//				s.setMaHangSua(rs.getString("ma_Hang_sua"));
//				s.setMaLoaiSua(rs.getNString("ma_loai_sua"));
//				dsSua.add(s);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dsSua;
//	}

	public static List<Sua> TimTheoLoaiHangTen(String maLoai, String maHang, String tenSua) {
		List<Sua> dsSua = null;
		try (Connection kn = CSDL.getKetNoi()) {
			PreparedStatement pst = kn
					.prepareStatement("select*from sua where ma_loai_sua = ? and ma_hang_sua=? and ten_sua like ?");
			pst.setString(1, maLoai);
			pst.setString(2, maHang);
			pst.setString(3, "%" + tenSua + "%");
			ResultSet rs = pst.executeQuery();
			dsSua = new ArrayList<>();
			while (rs.next()) {
				Sua s = new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setMaLoaiSua(rs.getString("ma_loai_sua"));
				s.setTenSua(rs.getString("ten_sua"));
				s.setMaHangSua(rs.getString("ma_hang_sua"));
				s.setTpDinhDuong(rs.getString("TP_Dinh_Duong"));
				s.setDonGia(rs.getInt("Don_gia"));
				s.setTrongLuong(rs.getString("Trong_luong"));
				s.setLoiIch(rs.getString("Loi_ich"));
				dsSua.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSua;
	}

	public static List<Sua> listSuaBanChay() {
		List<Sua> dsSua = null;
		try (Connection kn = CSDL.getKetNoi()) {
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT c.Ma_sua, SUM(c.So_luong) AS Tong_so_luong_da_ban, s.*"
					+ " FROM ct_hoadon c" + " INNER JOIN sua s ON c.Ma_sua = s.Ma_sua" + " GROUP BY c.Ma_sua, s.Ten_sua"
					+ " ORDER BY Tong_so_luong_da_ban DESC" + " LIMIT 5");
			dsSua = new ArrayList<>();
			while (rs.next()) {
				Sua s = new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("ten_sua"));
				s.setMaLoaiSua(rs.getString("ma_loai_sua"));
				s.setMaHangSua(rs.getString("ma_hang_sua"));
				dsSua.add(s);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSua;
	}

	public static Sua timTheoMa(String maLoai) {
		try (Connection kn = CSDL.getKetNoi()) {
			Sua s = new Sua();
			PreparedStatement pst = kn.prepareStatement("SELECT * FROM sua where Ma_sua =?");
			pst.setString(1, maLoai);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				s.setMaSua(rs.getString("ma_sua"));
				s.setMaLoaiSua(rs.getString("ma_loai_sua"));
				s.setTenSua(rs.getString("ten_sua"));
				s.setMaHangSua(rs.getString("ma_hang_sua"));
				s.setTpDinhDuong(rs.getString("TP_Dinh_Duong"));
				s.setDonGia(rs.getInt("Don_gia"));
				s.setTrongLuong(rs.getString("Trong_luong"));
				s.setHinh(rs.getString("Hinh"));
				s.setLoiIch(rs.getString("Loi_ich"));
			}
			return s;

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

}
