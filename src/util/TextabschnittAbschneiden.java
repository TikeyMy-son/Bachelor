package util;

public class TextabschnittAbschneiden {

	
	
	/**
	   * Returns the substring before the first occurrence of a delimiter. The
	   * delimiter is not part of the result.
	   *
	   * @param string    String to get a substring from.
	   * @param grenze    String to search for.
	   * @return          Substring before the first occurrence of the delimiter.
	   */
	  public static String substringBefore( String string, String grenze )
	  {
	    int positionIndex = string.indexOf( grenze );	//indexOf() beschreibt ab welchem zahlenwert angefangen wird zu gehen

	    return positionIndex >= 0 ? string.substring( 0, positionIndex ) : string;
	  }
	
	  
	
	/**
	   * Returns the substring after the first occurrence of a delimiter. The
	   * delimiter is not part of the result.
	   * @param string    String to get a substring from.
	   * @param grenze    String to search for.
	   * @return          Substring after the last occurrence of the delimiter.
	   */
	  public static String substringAfter( String string, String grenze )
	  {
	    int positionIndex = string.indexOf( grenze );

	    return positionIndex >= 0 ? string.substring( positionIndex + grenze.length() ) : "";
	  }

	
	
	
}
