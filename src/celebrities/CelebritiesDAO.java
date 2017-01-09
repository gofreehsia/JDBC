package celebrities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import celebrities.util.SystemConstant;


public class CelebritiesDAO {
	public CelebritiesDAO(){
		
	}
	
	String dbURL = SystemConstant.URL + "?user=" + SystemConstant.USER + "&password=" + SystemConstant.PASSWORD
			+ "&useSSL=true&useUnicode=yes&characterEncoding=UTF-8";
	private String readSQLFile(String filename) {
		try (FileInputStream fis = new FileInputStream(filename);
				InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
				BufferedReader br = new BufferedReader(isr);) {
			String line = "";
			StringBuffer sb = new StringBuffer();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void createTable() {
		String createStr = readSQLFile("createCelebrity.sql");
		String dropStr = readSQLFile("dropCelebrity.sql");

		try (Connection con = DriverManager.getConnection(dbURL); Statement stmt = con.createStatement();) {
			stmt.executeUpdate(dropStr);
			stmt.executeUpdate(createStr);
			System.out.println("表格重製成功");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	public void insert(CelebritiesBean cb) {
		
		String sql = "insert into Celebrity values(null, ?, ?, ?, ?, ?, ?)";
		String name = cb.getCeleName();
		String gender = cb.getGender();
		String urlPath = cb.getUrlpath();
		int num = cb.getNum();
		try{
		for(int i = 1;i <= num; i++){
			HttpURLConnection connection = download(urlPath, i);
		try (Connection con = DriverManager.getConnection(dbURL);
				PreparedStatement pstmt = con.prepareStatement(sql);
				InputStream is = connection.getInputStream();) {
			long fileSize = connection.getContentLengthLong();
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeStamp = sdf.format(d.getTime());
			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setString(3, name+i+".jpg");
			pstmt.setLong(4, fileSize);
			pstmt.setString(5, timeStamp);
			pstmt.setBinaryStream(6, is);
			pstmt.executeUpdate();
			
			System.out.println("Already updated "+name+" number: "+i);
			

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		}
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public HttpURLConnection download(String url, int num) throws IOException {
		URL imgUrl = new URL(url + num + ".jpg");
		HttpURLConnection connection = (HttpURLConnection) imgUrl.openConnection();
		return connection;
	}

}
