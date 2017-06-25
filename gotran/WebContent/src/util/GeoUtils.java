package util;


/**
 * Utilitário para operações geográficas
 * 
 * @author Thiago Galbiatti Vespa
 */
public class GeoUtils {

	/**
	 * Raio médio da terra em quilômetros Ref:
	 * http://en.wikipedia.org/wiki/Earth_radius
	 */
	public static int EARTH_RADIUS_KM = 6371;
	
	public double calculaDistancia(double lat1, double lng1, double lat2, double lng2) {
	    //double earthRadius = 3958.75;//miles
	    double earthRadius = 6371;//kilometers
	    double dLat = Math.toRadians(lat2 - lat1);
	    double dLng = Math.toRadians(lng2 - lng1);
	    double sindLat = Math.sin(dLat / 2);
	    double sindLng = Math.sin(dLng / 2);
	    double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
	            * Math.cos(Math.toRadians(lat1))
	            * Math.cos(Math.toRadians(lat2));
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double dist = earthRadius * c;
	 
	    return dist * 1; //em metros
	}

	/**
	 * Distância entre dois pontos geográficos. Os valores devem ser informados
	 * em graus.
	 * 
	 * @param firstLatitude
	 *            Latitude do primeiro ponto
	 * @param firstLongitude
	 *            Longitude do primeiro ponto
	 * @param secondLatitude
	 *            Latitude do segundo ponto
	 * @param secondLongitude
	 *            Longitude do segundo ponto
	 * 
	 * @return Distância em quilômetros entre os dois pontos
	 */
	public static double geoDistanceInKm(double firstLatitude,
			double firstLongitude, double secondLatitude, double secondLongitude) {

		// Conversão de graus pra radianos das latitudes
		double firstLatToRad = Math.toRadians(firstLatitude);
		double secondLatToRad = Math.toRadians(secondLatitude);

		// Diferença das longitudes
		double deltaLongitudeInRad = Math.toRadians(secondLongitude
				- firstLongitude);

		// Cálcula da distância entre os pontos
		return Math.acos(Math.cos(firstLatToRad) * Math.cos(secondLatToRad)
				* Math.cos(deltaLongitudeInRad) + Math.sin(firstLatToRad)
				* Math.sin(secondLatToRad))
				* EARTH_RADIUS_KM;
	}

	/**
	 * Distância entre dois pontos geográficos.
	 * 
	 * @param first
	 *            Primeira coordenada geográfica
	 * @param second
	 *            Segunda coordenada geográfica
	 * @return Distância em quilômetros entre os dois pontos
	 */
	public static double geoDistanceInKm(GeoCoordinate first,
			GeoCoordinate second) {
		return geoDistanceInKm(first.getLatitude(), first.getLongitude(),
				second.getLatitude(), second.getLongitude());
	}

}
