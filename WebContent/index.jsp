<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Would you like to play a game?</title>
</head>
<body>

<%
com.mcnz.rps.moai.Score score = (com.mcnz.rps.moai.Score)application.getAttribute("score");
if (score!=null) {
%>
<br><b><font color="navy">Global Score Counter</font></b>
<br/><font color="grey">Wins: <%=score.getWins() %> | Losses <%=score.getLosses() %> | Ties <%=score.getTies() %></font>
<hr/>
<br/>
<%} %>
      Which one will it be?<br/>
      <a href="playroshambo?choice=rock"> rock </a> &nbsp;
      <a href="playroshambo?choice=paper" > paper </a> &nbsp;
      <a href="playroshambo?choice=scissors" > scissors </a> &nbsp;

      <br/>





<%

Object o = session.getAttribute("gameHistory");
java.util.List<com.mcnz.rps.moai.GameSummary> history = (java.util.List<com.mcnz.rps.moai.GameSummary>)o;

if (history!=null && history.size()>0){
	
	com.mcnz.rps.moai.GameSummary summary = (com.mcnz.rps.moai.GameSummary)session.getAttribute("summary");
	com.mcnz.rps.moai.Result result = summary.getResult();
	if (result.equals(com.mcnz.rps.moai.Result.WIN)) {
		out.print("<h3>Congratulations, you won!</h3>");
	}
	if (result.equals(com.mcnz.rps.moai.Result.LOSE)) {
		out.print("<h3>Oh no, You lost!</h3>");
	}
	if (result.equals(com.mcnz.rps.moai.Result.TIE)) {
		out.print("<h3>Ho hum. You tied.</h3>");
	}
	
%>	
<br/>




<table style="border: 1px solid black;">
<tr ><th colspan="4"></th></tr>
<tr ><th colspan="4"><center><b>Game History</b> &nbsp;  <small><a href="playroshambo?choice=reset"> (reset) </a> </small> </center></th></tr>
<tr ><th colspan="4"></th></tr>
<tr ><th>Client Gesture</th><th>Server Gesture</th><th>Result</th><th>Time Played</th></tr>
	
<%	
	for (com.mcnz.rps.moai.GameSummary gameSummary : history) {
		out.println("<tr>");
		out.println("<td/>" + gameSummary.getClientGesture() + "</td>"); 
		out.println("<td/>" + gameSummary.getServerGesture() + "</td>");
		out.println("<td/>" + gameSummary.getResult() + "</td>");
		out.println("<td/>" + gameSummary.getDate() + "</td>");
		out.println("</tr>");
	}
%>	

</table>
		
<%
}
%>



</body>
</html>


