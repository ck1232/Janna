<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
{
    "className":      '',
    "orderable":      false,
    "data":           "",
    "defaultContent": '<div name="statusDiv" style="text-align:center;"><input type="checkbox" name="checkboxId"/></div>'
},
{"data": "invoiceId"},
{"data": "messenger"},
{"data": "totalAmt"},
{"data": "status"},
{	"data": "invoiceDate",
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
{
    "className":      '',
    "orderable":      false,
    "data":           null,
    "defaultContent": '<div name="payBtnDiv"><button name="payBtn" class="btn btn-primary" type="submit" form="payInvoiceForm">Pay</button></div>'+
    '<button name="viewBtn" class="btn btn-primary" type="submit" form="viewInvoiceForm">View</button>'
},