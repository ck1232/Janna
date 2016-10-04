    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <html>  
    <head>  
        <title>Spring Tiles Contact Form</title>  
    </head>  
    <body>  
    <h2>Contact Manager</h2>  
    <form:form method="post" action="addContact.html">  
      
        <table>  
        <tr>  
            <td><form:label path="firstname">First Name</form:label></td>  
            <td><form:input path="firstname" /></td>   
        </tr>  
        <tr>  
            <td><form:label path="lastname">Last Name</form:label></td>  
            <td><form:input path="lastname" /></td>  
        </tr>  
        <tr>  
            <td><form:label path="lastname">Email</form:label></td>  
            <td><form:input path="email" /></td>  
        </tr>  
        <tr>  
            <td><form:label path="lastname">Telephone</form:label></td>  
            <td><form:input path="telephone" /></td>  
        </tr>  
        <tr>  
            <td colspan="2">  
                <input type="submit" value="Add Contact"/>  
            </td>  
        </tr>  
    </table>    
    <p-fieldset toggleable>
		<legend>Personal details</legend>
     Content
	</p-fieldset>
	
	<p-dropdown name="option" filter>
    <option value="0">Select a City</option>
    <option value="1">Barcelona</option>
    <option value="2">Berlin</option>
    <option value="3">Istanbul</option>
	</p-dropdown>
    </form:form>  
    </body>  
    </html>  