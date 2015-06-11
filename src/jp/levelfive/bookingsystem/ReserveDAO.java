package jp.levelfive.bookingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReserveDAO {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;

		try {
			// データベースの指定
			String url = "jdbc:postgresql://localhost/booking";
			// データベースとの接続
			connection = DriverManager.getConnection(url, "levelfive",
					"levelfive");
			// ステートメントの取得
			statement = connection.createStatement();
			// SQL文の実行
			// 予約の空きを検索する
			String sql = "select starttime, endtime, roomnumber from reserve where date=?";
			resultset = statement.executeQuery(sql);
			// 結果の取得と処理
			while (resultset.next()) {
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultset.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
