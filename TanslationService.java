package com.mcnz.translator;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class TranslationService {


	@GET @Path("/translate")@Produces("text/plain")
	public String getWins(@HeaderParam("text") String text, @HeaderParam("language")  String language) {
		
		
		if(text==null) {
			return "text error";
		}
		
		if(language==null) {
			return "language error";
		}
		
		String languageModel = "en-"+language;
		System.out.println(languageModel);
		try {
			return WatsonTranslator.translate(text, languageModel);
		} catch (Exception e) {
			return e.getClass() + e.getMessage();
		}
	}
	
	@GET @Path("/score/losses")@Produces("text/plain")
	public String getLosses() {return "Losses";}
	     
	@GET @Path("/score/ties")@Produces("text/plain")
	public String getTies() {return "Ties";}
	

}
