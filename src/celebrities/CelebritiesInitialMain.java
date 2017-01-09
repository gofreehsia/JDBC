package celebrities;

public class CelebritiesInitialMain {

	public static void main(String[] args) {
		CelebritiesDAO dao =new CelebritiesDAO();
		dao.createTable();
		CelebritiesBean cbVin = new CelebritiesBean("Vin Diesel","M",
				"http://www.space-fox.com/wallpapers/celebsm/vin-diesel/vin_diesel_",9);
		CelebritiesBean cbTom= new CelebritiesBean("Tom Cruise","M",
				"http://www.space-fox.com/wallpapers/celebsm/tom-cruise/tom_cruise_",10);
		CelebritiesBean cbPene = new CelebritiesBean("Penelope Cruz","F",
				"http://www.space-fox.com/wallpapers/celebs/penelope-cruz/penelope_cruz_",64);
		dao.insert(cbVin);
		dao.insert(cbTom);
		dao.insert(cbPene);
		
	}
}
