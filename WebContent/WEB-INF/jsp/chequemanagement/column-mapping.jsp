<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
{"data": "chequeNum"},
{	"data": "chequeDate",
	"render": function (data) {
                 var date = new Date(data);
        		var month = date.getMonth();
        		var monthNames = [
							    "January", "February", "March",
							    "April", "May", "June", "July",
							    "August", "September", "October",
							    "November", "December"
							  ];
        		return date.getDate() + " " + monthNames[month] + " " + date.getFullYear();
             }
},
{"data": "chequeAmt"},
{"data": "bounceChequeInd"},
{"data": "paidFor"},
{
    "className":      '',
    "orderable":      false,
    "data":           null,
    "defaultContent": '<button name="viewBtn" class="btn btn-primary" type="submit" form="viewChequeForm">View</button>' +
    '<div name="editBtnDiv"><button name="editBtn" class="btn btn-primary" type="submit" form="updateChequeForm"><i class="fa fa-pencil"></i> Edit</button></div>' +
    '<div name="bounceBtnDiv"><button name="bounceBtn" class="btn btn-primary" type="submit" form="bounceChequeForm">Bounce</button></div>'
    
},